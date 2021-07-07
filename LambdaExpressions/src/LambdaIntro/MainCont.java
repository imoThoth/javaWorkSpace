package LambdaIntro;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
        //implements by creating anonymous class within upper concat as a parameter,
        //the second 2 parameters are String 1 and String 2
        System.out.println("The anonymous class name is " + getClass().getSimpleName());
        return MainCont.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String 1", "String 2");
    }
}

class Employee {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.age = age;
        this.name = name;
    }
}

public class MainCont {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Runnables and Lambdas");
            System.out.println("Second Line");
            System.out.format("Welcome to line %d\n", 3);
        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Time Buchalka", 21);
        Employee jack = new Employee("Jackie Doe", 28);
        Employee les = new Employee("Leslie Buchalka", 27);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(les);

//       Collections.sort(employees, new Comparator<Employee>(){
//            @Override
//            public int compare(Employee o1, Employee o2){
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//      Collections.sort(employees, Comparator.comparing(Employee::getName));

        Collections.sort(employees, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        Collections.sort(employees, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

    //Non Lambda example
        String sillyString = doStringStuff(new UpperConcat() {
                                               @Override
                                               public String upperAndConcat(String s1, String s2) {
                                                   return s1.toUpperCase() + s2.toUpperCase();
                                               }
                                           }, employees.get(0).getName(), employees.get(0).getName());
        System.out.println(sillyString);

        //Using Lambda Example
        //return keyword is assumed, and return type is inferred

        UpperConcat uc = (l1, l2) -> l1.toUpperCase() + l2.toUpperCase();
        String adultString = doStringStuff(uc, "Dog", "Potatoes");
        System.out.println("Prints out adultSTring" + adultString);

        //Adding multiple return types to a lambda execution
        UpperConcat ut = (a1,a2) -> {
           String result = a1.toUpperCase()+ a2.toUpperCase();
            return result;
        };

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}