import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

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

        Employers newLookEmployers = new Employers("Craig James", 54);
        Employers newLookEmployers2 = new Employers("Rickie Rico", 54);

        ArrayList<Employers> newLookEmployersList = new ArrayList<>();
        newLookEmployersList.add(newLookEmployers);
        newLookEmployersList.add(newLookEmployers2);

        // Generics, first parameter = parameter type... Second parameter = return type
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        String functionLastName = getLastName.apply(newLookEmployees.get(2));
        System.out.println(functionLastName);

        //Calling util function using a function
        Random random1 = new Random();
        for(Employee employee: newLookEmployees){
            if(random1.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            }else{
                System.out.println(getAName(getLastName, employee));
            }
        }

        // Returning last name without using util functions
        newLookEmployees.forEach( employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last Name: " + lastName);
        });
    }

    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }
}
