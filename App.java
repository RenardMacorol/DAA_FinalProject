import dataStructure.TwoThreeTree;
import employeePackage.Employee;
import userInteface.*;

public class App {
    public static void main(String[] args) {
      
      EmployeeDA employeeDa = new EmployeeDA("C:\\Users\\sevil\\New folder (7)\\DAA_FinalProject\\employeePackage\\emp.csv");  
      TwoThreeTree tree = employeeDa.readFromCSV();
      GUI newInterface = new GUI(tree, employeeDa);

       //EmployeeMain employeeManage = new EmployeeMain();

    }
}