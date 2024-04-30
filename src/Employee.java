public class Employee {
    String empId;
    String name;

    Employee(String empId,String name){
        this.empId= empId;
        this.name= name;
    }

    public String getEmpID() {
        return empId;
    }

    public String getName() {
        return name;
    }

}