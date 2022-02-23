
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import javax.swing.plaf.ProgressBarUI;

public class Controller {
    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;
    @FXML
    private ProgressBar progressBar;
    public void initialize() {
        task = new Task<ObservableList<String>>() {

            @Override
            protected ObservableList<String> call() throws Exception {
                String names={                        "Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson",
                        "Bob McDonald"};
                //Thread.sleep(1000);//simulates a database fecth
                ObservableList<String> employees= FXCollections.observableArrayList();

                for (int i = 0; i < 6; i++) {
                    employees.add(names[i]);
                    updateProgress(i+1,6);
                    Thread.sleep(200);
                }
                /*Platform.runLater(new Runnable(){
                    @Override
                    public void run(){
                        listView.setItems(employees);
                    }
                });*/
                return employees;
            }
        };
        listView.itemsProperty().bind(task.valueProperty());
    }
    @FXML
    public void buttonPressed(){
        new Thread(task).start();
    }
}
