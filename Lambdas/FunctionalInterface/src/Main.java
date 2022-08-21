import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
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

        System.out.println("**********************************************************");
        for(Employee employee: newLookEmployees){
            if(employee.getAge() % 2 == 0){
                System.out.println("Print Even Employee: " + employee.getName());
            }
        }

        System.out.println("==================== Using a Lambda ========================");
        newLookEmployees.forEach( employee -> {
            if(employee.getAge() % 2 != 0){
                System.out.println("Print Odd Employee " + employee.getName() );
            }
        });
    }
}
