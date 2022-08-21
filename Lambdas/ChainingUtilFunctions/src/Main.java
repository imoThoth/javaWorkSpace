import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

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

        Function<Employee, String> toUpper = employee -> employee.getName().toUpperCase();
        Function<String, String> getFirstName = name -> name.substring(0 , name.indexOf(' '));
        Function chainedFunction = toUpper.andThen(getFirstName);

        BiFunction<String, Employee, String > concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        System.out.println(chainedFunction.apply(newLookEmployees.get(3)));

        String firstBi = toUpper.apply(newLookEmployees.get(4));
        String secondBi = concatAge.apply(firstBi, newLookEmployees.get(3)); // change index
        System.out.println(secondBi);

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

    }
}
