import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Employee emp1 = new Employee("John Doe", 25);
        Employee emp2 = new Employee("Sam Doe", 26);
        Employee emp3 = new Employee("Craig Doe", 27);
        Employee emp4 = new Employee("Ryan Doe", 28);

        ArrayList<Employee> newportEmployees = new ArrayList<>();
        newportEmployees.add(emp1);
        newportEmployees.add(emp2);
        newportEmployees.add(emp3);
        newportEmployees.add(emp4);

        for(Employee employee: newportEmployees){
            System.out.println(employee.getName());
            new Thread( ()-> System.out.println(employee.getAge())).start();
        }
        System.out.println("********************************************************************************");

        for(int i =0; i < newportEmployees.size(); i++){
            Employee employee;
            employee = newportEmployees.get(i);
            System.out.println(employee.getName());
            new Thread( () -> System.out.println(employee.getAge())).start();
        }

        System.out.println("****Variable in a lambda must be defined in scope, be final, or relatively final*******");
//        Throws Error
//        Employee employee;
//        for(int i = 0; i < newportEmployees.size(); i++){
//            employee = newportEmployees.get(i);
//            System.out.println(employee.getName());
//           new Thread( () -> System.out.println(employee.getAge())).start(); ;
//        }

        System.out.println("*******************************************************************************");

        Employee emp5 = new Employee("Daisy Ryler", 25);
        Employee emp6 = new Employee("Dianne Ryler", 26);
        Employee emp7 = new Employee("Donovan Ryler", 27);
        Employee emp8 = new Employee("Donathan Ryler", 28);

        ArrayList<Employee> newLookEmployees = new ArrayList<>();
        newLookEmployees.add(emp5);
        newLookEmployees.add(emp6);
        newLookEmployees.add(emp7);
        newLookEmployees.add(emp8);

        newLookEmployees.forEach( employee -> {
            System.out.println("Employee Name " + employee.getName());
        });


    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}
