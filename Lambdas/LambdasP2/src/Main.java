import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Employee emp1 = new Employee("John Doe", 30);
        Employee emp2 = new Employee("Sam Doe", 30);
        Employee emp3 = new Employee("Craig Doe", 30);
        Employee emp4 = new Employee("Ryan Doe", 30);

        ArrayList<Employee> newportEmployees = new ArrayList<>();
        newportEmployees.add(emp1);
        newportEmployees.add(emp2);
        newportEmployees.add(emp3);
        newportEmployees.add(emp4);

        String annonymous = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, newportEmployees.get(0).getName(), newportEmployees.get(1).getName());

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();

        String lambdaString = doStringStuff(uc, newportEmployees.get(3).getName(), newportEmployees.get(0).getName());

        System.out.println("Lambda: " + lambdaString);
        System.out.println("Annonymous: " + annonymous);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}
