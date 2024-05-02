import java.util.HashMap;

public class Department {
    private String depCode;
    private String depName;
    private Double depTotalSalary = 0.00;
    private HashMap<String, Employee> employeeMap;

    public Department() {
        employeeMap = new HashMap<>();
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDepTotalSalary(Double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }

    public void setEmployeeMap(HashMap<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public String getDepCode() {
        return depCode;
    }

    public String getDepName() {
        return depName;
    }

    public Double getDepTotalSalary() {
        return depTotalSalary;
    }

    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}