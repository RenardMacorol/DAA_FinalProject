class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void readFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int empNo = Integer.parseInt(data[0]);
                String lastName = data[1];
                String firstName = data[2];
                double salary = Double.parseDouble(data[3]);
                String department = data[4];
                String jobDesc = data[5];
                employees.add(new Employee(empNo, lastName, firstName, salary, department, jobDesc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // Optionally, you can add methods for writing to CSV file as well
}
