public class Employee {
    int empId;
    String employeeName;
    Double salary;
    String jobDesc;

    Employee(int empId,String name, Double salary,String jobDesc){
        this.empId= empId;
        this.employeeName= name;
        this.salary= salary;
        this.jobDesc= jobDesc;
    }

    public int getEmpID() {
        return empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Double getSalary(){
        return salary;
    }

    public String getJobDesc(){
        return jobDesc;
    }

}