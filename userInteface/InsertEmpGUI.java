package userInteface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InsertEmpGUI implements ActionListener {
    JFrame insertFrame;
    JTextField empNoField;
    JTextField lastNameField;
    JTextField firstNameField;
    JTextField salaryField;
    JTextField departmentField;
    JTextField jobDescField;
    JButton submitButton;
    int latestEmpNo;

    public InsertEmpGUI(int latestEmpNo) {
        this.latestEmpNo = latestEmpNo;

        insertFrame = new JFrame("Insert New Employee");
        insertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        insertFrame.setSize(500, 300);
        insertFrame.setLayout(new GridLayout(7, 2));

        JLabel empNoLabel = new JLabel("Employee Number:");
        empNoField = new JTextField(String.valueOf(latestEmpNo + 1));
        empNoField.setEditable(false);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();

        JLabel salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField();

        JLabel departmentLabel = new JLabel("Department:");
        departmentField = new JTextField();

        JLabel jobDescLabel = new JLabel("Job Description:");
        jobDescField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        insertFrame.add(empNoLabel);
        insertFrame.add(empNoField);
        insertFrame.add(lastNameLabel);
        insertFrame.add(lastNameField);
        insertFrame.add(firstNameLabel);
        insertFrame.add(firstNameField);
        insertFrame.add(salaryLabel);
        insertFrame.add(salaryField);
        insertFrame.add(departmentLabel);
        insertFrame.add(departmentField);
        insertFrame.add(jobDescLabel);
        insertFrame.add(jobDescField);
        insertFrame.add(new JLabel());
        insertFrame.add(submitButton);

        insertFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                int empNo = Integer.parseInt(empNoField.getText());
                String lastName = lastNameField.getText();
                String firstName = firstNameField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                String department = departmentField.getText();
                String jobDesc = jobDescField.getText();

                // format chuchu
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\sevil\\New folder (7)\\DAA_FinalProject\\employeePackage\\emp.csv", true))) {
                    writer.write(empNo + "," + lastName + "," + firstName + "," + salary + "," + department + "," + jobDesc + "\n");
                }

                JOptionPane.showMessageDialog(insertFrame, "Employee added successfully.");
                insertFrame.dispose(); 
            } catch (NumberFormatException | IOException ex) {
                JOptionPane.showMessageDialog(insertFrame, "Error: Invalid input format.");
            }
        }
    }
}
