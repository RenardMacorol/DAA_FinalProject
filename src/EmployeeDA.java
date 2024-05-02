import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeDA {
    private HashMap<String, Employee> employeeMap;


    public EmployeeDA() {
        employeeMap = new HashMap<>();
        readEmployee();
    }


    private void readEmployee() {
        try {
            Scanner employeeFile = new Scanner(new FileReader("/workspaces/Lab_Assign5/emp.csv"));
            employeeFile.nextLine(); 
            while (employeeFile.hasNextLine()) {
                String empLine = employeeFile.nextLine();
                String[] empArr = empLine.split(",");
                String empNo = empArr[0].trim();
                Employee employee = new Employee();
                employee.setEmpNo(empNo);
                employee.setLastName(empArr[1].trim());
                employee.setFirstName(empArr[2].trim());
                employeeMap.put(empNo, employee);
            }
            employeeFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Employee getEmployee(String empNo) {
        return employeeMap.get(empNo);
    }
}