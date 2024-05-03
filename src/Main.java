public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.readFromCSV("emp.csv");

        // Example: Printing the employees
        List<Employee> employees = manager.getEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.toString());
        }
    }
}