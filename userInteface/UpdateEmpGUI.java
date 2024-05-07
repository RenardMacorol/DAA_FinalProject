package userInteface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.*;
import dataStructure.Node;
import dataStructure.TwoThreeTree;
import employeePackage.Employee;

public class UpdateEmpGUI {
    private JFrame frame;
    private TwoThreeTree tree;
    private DecimalFormat decimalFormat;
    private Employee employee;

    public UpdateEmpGUI(JFrame frame, TwoThreeTree tree, DecimalFormat decimalFormat) {
        this.frame = frame;
        this.tree = tree;
        this.decimalFormat = decimalFormat;
        displayInputPrompt();
    }

    private void displayInputPrompt() {
        String empNoInput = JOptionPane.showInputDialog(frame, "Enter Employee number:");
        if (empNoInput != null && !empNoInput.isEmpty()) {
            if (isValidEmpNo(empNoInput)) {
                int empNo = Integer.parseInt(empNoInput);
                Node resultNode = tree.search(empNo);
                if (resultNode != null) {
                    displayEmployeeDetails(resultNode, empNo);
                } else {
                    JOptionPane.showMessageDialog(frame, "Employee not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Employee Number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean isValidEmpNo(String empNoInput) {
        return empNoInput.matches("\\d+");
    }

    private void displayEmployeeDetails(Node resultNode, int empNo) {
        JTextField resultEmployeeID = new JTextField();
        JTextField resultEmployeeName = new JTextField();
        JTextField resultEmployeeSalary = new JTextField();
        JTextField resultEmployeeDepartment = new JTextField();
        JTextField resultEmployeeJobDesc = new JTextField();
        resultEmployeeID.setEditable(false);

        for (int i = 0; i < resultNode.numKeys; i++) {
            employee = resultNode.keys[i];
            if (employee.getEmpNo() == empNo) {
                resultEmployeeID.setText(Integer.toString(employee.getEmpNo()));
                resultEmployeeName.setText(employee.getLastName() + ", " + employee.getFirstName());
                resultEmployeeSalary.setText(decimalFormat.format(employee.getSalary()));
                resultEmployeeDepartment.setText(employee.getDepartment());
                resultEmployeeJobDesc.setText(employee.getJobDesc());
            }
        }

        Object[] message = {
                "Employee ID:", resultEmployeeID,
                "Name:", resultEmployeeName,
                "Monthly Salary:", resultEmployeeSalary,
                "Department:", resultEmployeeDepartment,
                "Job Description:", resultEmployeeJobDesc
        };
        int option = JOptionPane.showConfirmDialog(frame, message, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            String updatedEmployeeName = resultEmployeeName.getText();
            String updatedEmployeeSalaryText = resultEmployeeSalary.getText();
            String updatedEmployeeDepartment = resultEmployeeDepartment.getText();
            String updatedEmployeeJobDesc = resultEmployeeJobDesc.getText();

            // Check if salary text is empty or non-numeric before parsing
            if (!updatedEmployeeSalaryText.isEmpty() && updatedEmployeeSalaryText.matches("\\d+(\\.\\d+)?")) {
                double updatedEmployeeSalary = Double.parseDouble(updatedEmployeeSalaryText);
                // Create updated employee data string
                String updatedEmployeeData = String.format("%s, %s, %.2f, %s, %s", employee.getEmpNo(), updatedEmployeeName, updatedEmployeeSalary, updatedEmployeeDepartment, updatedEmployeeJobDesc);
                // Update CSV file
                updateEmployeeCSV(empNo, updatedEmployeeData);
            } else {
                // Handle empty or non-numeric salary
                JOptionPane.showMessageDialog(frame, "Invalid salary format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateEmployeeCSV(int empNo, String updatedEmployeeData) {
        String csvFile = "employeePackage\\emp.csv";
        String tempFile = "temp.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                int employeeID = Integer.parseInt(parts[0].trim());
                if (employeeID == empNo) {
                    bw.write(updatedEmployeeData);
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File oldFile = new File(csvFile);
        File newFile = new File(tempFile);
        if (newFile.renameTo(oldFile)) {
            System.out.println("CSV file updated successfully.");
        } else {
            System.out.println("Failed to update CSV file.");
        }
    }
}
