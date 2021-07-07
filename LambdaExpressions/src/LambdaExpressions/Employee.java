package LambdaExpressions;

import java.util.ArrayList;
import java.util.List;

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

interface UpperrConcatt {
    String upperrAndConcatt(String s1, String s2);
}

class doesSomething{
    public String doSomething(){
        UpperConcatt uc = (s1,s2) -> {
            String result = "String1" + "String2";
            return result;
        };
        return Main.doStringStuff(uc, "String1", "String2");
    }

}

 class Main {
     public static void main(String[] args) {
         Employee john = new Employee("John Doe", 30);
         Employee tim = new Employee("Time Buchalka", 21);
         Employee jack = new Employee("Jackie Doe", 28);
         Employee les = new Employee("Leslie Buchalka", 27);

         List<Employee> employees = new ArrayList<Employee>();
         employees.add(john);
         employees.add(tim);
         employees.add(jack);
         employees.add(les);

         for(Employee employee : employees){
             System.out.println(employee.getName());
             new Thread(() -> System.out.println(employee.getAge())).start();
         }

         System.out.println("*********Using Lambda Expressions**************");
         //Iterating through collections can be used with lambda expressions
         //For each takes a lambda expression, evaluates the iteration with the iterable collection
        employees.forEach(employee -> {
            System.out.println(employee.getAge());
            System.out.println(employee.getName());
        });
     }
     public final static String doStringStuff(UpperConcatt uc, String s1, String s2) {
         return uc.upperAndConcatt(s1, s2);
     }
 }
