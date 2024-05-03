import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileWriter;

class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void writeToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            for (Employee emp : employees) {
                writer.println(emp.getEmpNo() + "," + emp.getLastName() + "," + emp.getFirstName() + "," +
                        emp.getSalary() + "," + emp.getDepartment() + "," + emp.getJobDesc());
            }
            System.out.println("Employee data written to CSV file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}