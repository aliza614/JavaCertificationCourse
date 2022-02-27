import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();
 /*       new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable class");
            }
        }).start();
 */
        new Thread(()-> {
            System.out.println("Printing from the Runnable class");
            System.out.println("Line2");
            System.out.format("This is line %d\n",3);
        }).start();
        Employee john=new Employee("John Doe",30);
        Employee tim=new Employee("Tim Buchalka", 21);
        Employee jack=new Employee("Jack Hill", 40);
        Employee snow=new Employee("Snow White",22);

        List<Employee> employees=new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

    /*    Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });
*/
        Collections.sort(employees, (/*Employee*/ employee1, /*Employee*/ employee2)->
                employee1.getName().compareTo(employee2.getName()));
        for(Employee employee : employees)
        {
            System.out.println(employee.getName());
        }


    }
}
class CodeToRun implements Runnable{
    @Override
    public void run(){
        System.out.println("Printing from the Runnable");
    }

}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class AnotherClass{
    public void  doSomething(){
    }
    public void printValue(){
        int number=25;
        Runnable r=()-> {
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value is "+number);
        };

        new Thread(r).start();
    }
}

