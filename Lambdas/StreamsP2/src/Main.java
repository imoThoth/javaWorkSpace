import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee emp1 = new Employee("Mary Sheppard", 23 );
        Employee emp2 = new Employee("Angie Rosmauck", 25 );
        Employee emp3 = new Employee("Sarah Silverman", 24 );
        Employee emp4 = new Employee("Siobhan Soias", 20 );
        Employee emp5 = new Employee("Ryan Garcia", 23 );
        Employee emp6 = new Employee("Stevo Amries", 25 );

        Department hr = new Department("IT & Communications");

        hr.addEmployee(emp1);
        hr.addEmployee(emp2);
        hr.addEmployee(emp3);

        Department acc = new Department("Accounting and Financing");

        acc.addEmployee(emp4);
        acc.addEmployee(emp5);
        acc.addEmployee(emp6);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(hr);
        departmentList.add(acc);

        departmentList.stream()
                .flatMap(department -> department.getEmployees().stream()) // iterate through a list within a list
                .forEach(System.out::println);

        System.out.println("===================================================================");
        List<String> moreBingoNumbers = Arrays.asList(
                "I1", "I16", "I27", "H15",
                "E8", "E19", "E29", "e49",
                "D10", "D21" , "D30", "d3",
                "A40", "A36", "A24", "i31",
                "H7",  "H22", "h37", "a4"

        );

        List<String> sortedBingoNumbers =  moreBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("s"))
                .sorted()
                .collect(Collectors.toList());

        for(String s: sortedBingoNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupByAge = departmentList.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println(groupByAge);

        System.out.println("--------------------------------Find Youngest-----------------------------------------");

        departmentList.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
    }
}
