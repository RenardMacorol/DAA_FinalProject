package userInteface;

import java.text.DecimalFormat;

import javax.swing.*;
import dataStructure.Node;
import dataStructure.TwoThreeTree;
import employeePackage.Employee;

public class UpdateEmpGUI {
    private JFrame frame;
    private TwoThreeTree tree;
    private DecimalFormat decimalFormat;

    public UpdateEmpGUI(JFrame frame,TwoThreeTree tree, DecimalFormat decimalFormat) {
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
                    displayEmployeeDetails(resultNode,Integer.parseInt(empNoInput));
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

    

    private void displayEmployeeDetails(Node resultNode,int empNo) {
        JTextField resultEmployeeID = new JTextField();
        JTextField resultEmployeeName = new JTextField();
        JTextField resultEmployeeSalary = new JTextField();
        JTextField resultEmployeeDepartment = new JTextField();
        JTextField resultEmployeeJobDesc = new JTextField();

        for(int i=0;i < resultNode.numKeys; i++){
            Employee employee = resultNode.keys[i];
            if(employee.getEmpNo() == empNo){
                resultEmployeeID.setText(Integer.toString(employee.getEmpNo()) );
                resultEmployeeName.setText( employee.getLastName()+ ", " +employee.getFirstName());
                resultEmployeeSalary.setText( decimalFormat.format(employee.getSalary()) );
                resultEmployeeDepartment.setText( employee.getDepartment());
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
            String updatedEmployeeID = resultEmployeeID.getText();
            String updatedEmployeeName = resultEmployeeName.getText();
            double updatedEmployeeSalary = Double.parseDouble(resultEmployeeSalary.getText());
            String updatedEmployeeDepartment = resultEmployeeDepartment.getText();
            String updatedEmployeeJobDesc = resultEmployeeJobDesc.getText();

    
        }
    }
}

