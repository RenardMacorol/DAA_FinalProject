import dataStructure.TwoThreeTree;
import employeePackage.Employee;
import userInteface.*;

public class App {
    public static void main(String[] args) {
      
      EmployeeDA employeeDa = new EmployeeDA("employeePackage\\emp.csv");  
      TwoThreeTree tree = employeeDa.readFromCSV();
      GUI newInterface = new GUI(tree, employeeDa);

       //EmployeeMain employeeManage = new EmployeeMain();

    }
}