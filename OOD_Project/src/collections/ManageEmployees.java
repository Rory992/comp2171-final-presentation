package collections;

import paysys.Employee;

import java.util.ArrayList;

/**
 * @author Rory Young
 */
public class ManageEmployees {
    private final ArrayList<Employee> employeeList;

    public ManageEmployees(ArrayList<Employee> lst) {
        employeeList = lst;
    }

    public void addEmployee (Employee emp) {
        employeeList.add(emp);
    }

    public Employee getEmployee (int id) {
        for (Employee employee:employeeList) {
            if (employee.getEmployeeID()==id) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmployee(String fName, String lName){
        for (Employee employee : employeeList) {
            if (employee.getName().getFirstName().equalsIgnoreCase(fName)) {
                if (employee.getName().getLastName().equalsIgnoreCase(lName)){
                    return employee;
                }
            }
        }
        return null;
    }

    public void removeEmployee (int id) {
        employeeList.removeIf(employee -> employee.getEmployeeID() == id);
    }

    public void removeEmployee (String fName, String lName) {
        employeeList.removeIf(employee -> employee.getName().getFirstName().equalsIgnoreCase(fName) && employee.getName().getLastName().equalsIgnoreCase(lName));
    }

    public int size(){
        return employeeList.size();
    }

    public ArrayList<Employee> getList(){return employeeList;}

}