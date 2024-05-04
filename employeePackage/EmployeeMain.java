package employeePackage;

import java.util.Scanner;

public class EmployeeMain {
    EmployeeMain(){
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        boolean addingEmployee = true;
        while (addingEmployee) {
            System.out.println("Enter employee data");
            System.out.print("Employee Number: ");
            int empNo = scanner.nextInt();
            if (empNo == 0) {
                addingEmployee = false; 
                break;
            }

            System.out.print("Last Name: ");
            String lastName = scanner.next();

            System.out.print("First Name: ");
            String firstName = scanner.next();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            System.out.print("Department: ");
            String department = scanner.next();

            System.out.print("Job Description: ");
            String jobDesc = scanner.next();

            manager.addEmployee(new Employee(empNo, lastName, firstName, salary, department, jobDesc));

            System.out.print("Do you want to add another employee? (yes/no): ");
            String choice = scanner.next();
            addingEmployee = choice.equalsIgnoreCase("yes");
        }

        String filename = "/workspaces/DAA_FinalProject/src/emp.csv";
        manager.writeToCSV(filename);

        System.out.println("Employee data saved to " + filename);

        scanner.close();
    }
   
}