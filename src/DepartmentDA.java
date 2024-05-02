import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class DepartmentDA {
    private HashMap<String, Department> departmentMap;
    private EmployeeDA employeeDA; 

    // Constructor
    public DepartmentDA() {
        this.departmentMap = readDept();
        this.employeeDA = new EmployeeDA(); 
        readDepEmp();
    }


    private HashMap<String, Department> readDept() {
        HashMap<String, Department> departments = new HashMap<>();
        try {
            Scanner departmentFile = new Scanner(new FileReader("/workspaces/Lab_Assign5/dep.csv"));
            departmentFile.nextLine();

            while (departmentFile.hasNext()) {
                String departmentLine = departmentFile.nextLine();
                String[] depArr = departmentLine.split(",");
                Department department = new Department();
                department.setDepCode(depArr[0].trim());
                department.setDepName(depArr[1].trim());
                departments.put(depArr[0].trim(), department);
            }

            departmentFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }


    private void readDepEmp() {
        try {
            Scanner depEmpFile = new Scanner(new FileReader("/workspaces/Lab_Assign5/deptemp.csv"));
            depEmpFile.nextLine();
            while (depEmpFile.hasNext()) {
                String depEmpLine = depEmpFile.nextLine();
                String[] depEmpArr = depEmpLine.split(",");
                Department department = departmentMap.get(depEmpArr[0].trim());
                if (department != null) {
                    String empNo = depEmpArr[1].trim();
                    Employee employee = employeeDA.getEmployee(empNo); 
                    if (employee != null) {
                        employee.setSalary(Double.parseDouble(depEmpArr[2]));
                        department.getEmployeeMap().put(empNo, employee); 
                        department.setDepTotalSalary(department.getDepTotalSalary() + employee.getSalary());
                    }
                }
            }
            depEmpFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void printDepartment(Department department) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Department Code: " + department.getDepCode());
        System.out.println("Department Name: " + department.getDepName());
        System.out.println("Department total Salary: " + df.format(department.getDepTotalSalary()));
        System.out.println("------------Details----------------");
        System.out.printf("%-10s %-20s %10s\n", "EmpNo", "EmployeeName", "Salary");
        for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
            Employee employee = entryMap.getValue();
            System.out.printf("%-10s %-20s %10s\n", entryMap.getKey(),
            employee.getLastName() + ", " + employee.getFirstName(), df.format(employee.getSalary()));
        }
        System.out.println();
        
    }

    public HashMap<String, Department> getDepartmentMap() {
        return departmentMap;
    }
}