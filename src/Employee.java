public class Employee {
    private int empNo;
    private String lastName;
    private String firstName;
    private Double salary;
    private String department;
    private String jobDesc;

    Employee(){

    }

    Employee(int empNo, String lastName,String firstName, Double salary, String department, String jobDesc){
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.department = department;
        this.jobDesc = jobDesc;
    }

    public void setDepartment(String department){
        this.department= department;
    }

    public void setJobDescription(String jobDesc){
        this.jobDesc = jobDesc;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Double getSalary() {
        return salary;
    }

    public String getJobDescription(){
        return jobDesc;
    }

    public String getDepartment(){
        return department;
    }
}