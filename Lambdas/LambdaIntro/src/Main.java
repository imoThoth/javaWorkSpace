import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        // before lambdas
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable thread");
//            }
//        }).start();

        //using lambdas

        new Thread( () -> System.out.println("Printing from runnable")).start();

        //Printing multiple lines
        new Thread ( () -> {
            System.out.println("Printing \n from first line");
            System.out.println("Printing from \n second line");
            System.out.println("Printing from third \n line");
        }).start();

        Employee emp1 = new Employee("John Doe", 30);
        Employee emp2 = new Employee("Sam Doe", 30);
        Employee emp3 = new Employee("Craig Doe", 30);
        Employee emp4 = new Employee("Ryan Doe", 30);

        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        for(Employee employeeName : employeeList){
            System.out.println(employeeName.getName());
        }

    }
}

class CodeToRun implements Runnable {
    @Override
    public void run(){
        System.out.println("Printing from the runnable");
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