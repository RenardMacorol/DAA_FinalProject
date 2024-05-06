package userInteface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import dataStructure.TwoThreeTree;
import employeePackage.Employee;

public class EmployeeDA {
    private String filename;

    public EmployeeDA(String filename) {
        this.filename = filename;
    }

    // Method to read employee data from the CSV file and populate a 2-3 tree
    public TwoThreeTree readFromCSV() {
        TwoThreeTree tree = new TwoThreeTree(3);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int empNo = Integer.parseInt(parts[0]);
                    String lastName = parts[1];
                    String firstName = parts[2];
                    double salary = Double.parseDouble(parts[3]);
                    String department = parts[4];
                    String jobDesc = parts[5];
                    tree.insert(new Employee(empNo, lastName, firstName, salary, department, jobDesc));
                } else {
                    System.out.println("Invalid data in CSV file: " + line);
                }
            }
            System.out.println("Employee data read from CSV file successfully.");
        } catch (IOException e) {
            System.err.println("Error reading from CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return tree;
    }

    
    public void writeToCSV(Employee employee) {

    }

    // Method for latest empNo chuchu
    public int getLatestEmpNo() {
        int latestEmpNo = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int empNo = Integer.parseInt(parts[0]);
                    if (empNo > latestEmpNo) {
                        latestEmpNo = empNo;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return latestEmpNo;
    }
}
