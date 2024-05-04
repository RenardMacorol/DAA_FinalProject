import dataStructure.TwoThreeTree;
import employeePackage.Employee;
import userInteface.*;

public class App {
    public static void main(String[] args) {
       
        TwoThreeTree tree = new TwoThreeTree(5); // Minimum degree is 3\
        //for test purpose need ng csv reader tapos doon kukuha 
       Employee employee0 = new Employee(123, "Macorol", "Renard", 23000.00, "Dev department", "Software Engineer");
       Employee employee1 = new Employee(124, "John", "Doe", 25000.00, "HR department", "HR Manager");
       Employee employee2 = new Employee(125, "Alice", "Smith", 27000.00, "Marketing department", "Marketing Specialist");
       Employee employee3 = new Employee(126, "Bob", "Johnson", 22000.00, "Finance department", "Accountant");
       Employee employee4 = new Employee(127, "Emily", "Brown", 24000.00, "Sales department", "Sales Representative");
       Employee employee5 = new Employee(128, "Michael", "Davis", 26000.00, "IT department", "Systems Administrator");
       Employee employee6 = new Employee(129, "Emma", "Wilson", 28000.00, "Customer Service department", "Customer Support Specialist");
       Employee employee7 = new Employee(130, "James", "Taylor", 21000.00, "Operations department", "Operations Coordinator");
       Employee employee8 = new Employee(131, "Sophia", "Anderson", 29000.00, "Quality Assurance department", "QA Analyst");
       Employee employee9 = new Employee(132, "Olivia", "Martinez", 20000.00, "Research and Development department", "Research Scientist");
    
       tree.insert(employee0);
       tree.insert(employee1);
       tree.insert(employee2);
       tree.insert(employee3);
       tree.insert(employee4);
       tree.insert(employee5);
       tree.insert(employee6);
       tree.insert(employee7);
       tree.insert(employee8);
       tree.insert(employee9);


        tree.traverse();
            
      GUI newInterface = new GUI(tree);

       //EmployeeMain employeeManage = new EmployeeMain();

    }
}
