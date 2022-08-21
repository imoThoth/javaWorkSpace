import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Employee emp1 = new Employee("John Doe", 25);
        Employee emp2 = new Employee("Sam Doe", 24);
        Employee emp3 = new Employee("Craig Doe", 22);
        Employee emp4 = new Employee("Ryan Doe", 18);
        Employee emp5 = new Employee("Daisy Ryler", 29);
        Employee emp6 = new Employee("Dianne Ryler", 48);
        Employee emp7 = new Employee("Donovan Ryler", 33);
        Employee emp8 = new Employee("Donathan Ryler", 39);

        ArrayList<Employee> newLookEmployees = new ArrayList<>();
        newLookEmployees.add(emp5);
        newLookEmployees.add(emp6);
        newLookEmployees.add(emp7);
        newLookEmployees.add(emp8);
        newLookEmployees.add(emp1);
        newLookEmployees.add(emp2);
        newLookEmployees.add(emp3);
        newLookEmployees.add(emp4);

        printEmployeesByAge(newLookEmployees, "Employee over 28", employee -> employee.getAge() > 28);
        printEmployeesByAge(newLookEmployees,"Employees less than the age of 27",  employee -> employee.getAge() < 27);

        //Using annonymous class
        printEmployeesByAge(newLookEmployees, "Employees younger than 20", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 20;
            }
        });

    }

    private static void printEmployeesByAge(List<Employee> employeeList, String ageText, Predicate<Employee> ageCondition){
        System.out.println(" \n" + ageText  );
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for(Employee employee: employeeList){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}
