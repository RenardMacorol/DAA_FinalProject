package userInteface;

import javax.swing.*;
import dataStructure.Node;
import employeePackage.Employee;

public class UpdateEmpGUI {
    private JFrame frame;

    public UpdateEmpGUI(JFrame frame) {
        this.frame = frame;
        displayInputPrompt();
    }

    private void displayInputPrompt() {
        String empNoInput = JOptionPane.showInputDialog(frame, "Enter Employee number:");
        if (empNoInput != null && !empNoInput.isEmpty()) {
            if (isValidEmpNo(empNoInput)) {
                int empNo = Integer.parseInt(empNoInput);
                Node resultNode = retrieveEmployeeNode(empNo);
                if (resultNode != null) {
                    displayEmployeeDetails(resultNode);
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

    private Node retrieveEmployeeNode(int empNo) {
        return null;
    }

    private void displayEmployeeDetails(Node resultNode) {
        JTextField resultEmployeeID = new JTextField();
        JTextField resultEmployeeName = new JTextField();
        JTextField resultEmployeeSalary = new JTextField();
        JTextField resultEmployeeDepartment = new JTextField();
        JTextField resultEmployeeJobDesc = new JTextField();

        Object[] message = {
                "Employee ID:", resultEmployeeID,
                "Name:", resultEmployeeName,
                "Monthly Salary:", resultEmployeeSalary,
                "Department:", resultEmployeeDepartment,
                "Job Description:", resultEmployeeJobDesc
        };
        int option = JOptionPane.showConfirmDialog(frame, message, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String updatedEmployeeID = resultEmployeeID.getText();
    String updatedEmployeeName = resultEmployeeName.getText();
    double updatedEmployeeSalary = Double.parseDouble(resultEmployeeSalary.getText());
    String updatedEmployeeDepartment = resultEmployeeDepartment.getText();
    String updatedEmployeeJobDesc = resultEmployeeJobDesc.getText();

    employee.setEmpNo(Integer.parseInt(updatedEmployeeID));
        }
    }
}

