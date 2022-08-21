import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee emp1 = new Employee("John Doe", 30);
        Employee emp2 = new Employee("Sam Doe", 30);
        Employee emp3 = new Employee("Craig Doe", 30);
        Employee emp4 = new Employee("Ryan Doe", 30);

        ArrayList<Employee> newportEmployees = new ArrayList<>();
        newportEmployees.add(emp1);
        newportEmployees.add(emp2);
        newportEmployees.add(emp3);
        newportEmployees.add(emp4);

        Employee emp5 = new Employee("Aaron Smith", 30);
        Employee emp6 = new Employee("Valentine Smith", 30);
        Employee emp7 = new Employee("Thomas Smith", 30);
        Employee emp8 = new Employee("Mary Smith", 30);

        List<Employee> sainsburyEmployees = new ArrayList<>();
        sainsburyEmployees.add(emp5);
        sainsburyEmployees.add(emp6);
        sainsburyEmployees.add(emp7);
        sainsburyEmployees.add(emp8);

        // uses lambda to sort through employee name, arranging them by age (parameter) -> (body)
        Collections.sort(newportEmployees, (Employee employee1, Employee employee2) ->
            employee1.getName().compareTo(employee2.getName()));

        // if compiler can infer type, type declaration can be left out
        Collections.sort(sainsburyEmployees, (name1, name2) -> name1.getName().compareTo(name2.getName()));
        
        for(Employee employeeName : newportEmployees){
            System.out.println(employeeName.getName());
        }

        for(Employee employeeName : sainsburyEmployees){
            System.out.println(employeeName.getName());
        }
    }
}
