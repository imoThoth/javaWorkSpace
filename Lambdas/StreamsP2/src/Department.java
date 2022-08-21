import java.util.*;
import java.util.ArrayList;

public class Department {

    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> getEmployees(){
        return employeeList;
    }
}
