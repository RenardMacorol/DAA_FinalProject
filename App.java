import dataStructure.TwoThreeTree;
import employeePackage.Employee;
import userInteface.*;

public class App {
    public static void main(String[] args) {
       
        TwoThreeTree tree = new TwoThreeTree(5); // Minimum degree is 3\
        //for test purpose need ng csv reader tapos doon kukuha 
       Employee employee0 = new Employee(123, "Macorol", "Renard", 23000.00, "Dev department", "Software Engineer");
       
    

       tree.insert(employee0);

        tree.traverse();
            
      GUI newInterface = new GUI(tree);

       //EmployeeMain employeeManage = new EmployeeMain();

    }
}
