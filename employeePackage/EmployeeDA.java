package employeePackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dataStructure.TwoThreeTree;

public class EmployeeDA {
    private String filename;

    public EmployeeDA(String filename) {
        this.filename = filename;
    }

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
}
