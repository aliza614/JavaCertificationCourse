
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee john=new Employee("John Doe",30);
        Employee jane=new Employee("Jane Deer", 25);
        Employee jack=new Employee("Jack Hill", 40);
        Employee snow=new Employee("Snow White", 22);

        Department hr=new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting =new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments=new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
    }
}