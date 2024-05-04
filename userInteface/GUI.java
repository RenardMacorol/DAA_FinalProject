package userInteface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dataStructure.*;
import dataStructure.TwoThreeTree;
import employeePackage.Employee;


public class GUI implements ActionListener{
    JFrame mainFrame;
    JButton employeeButton;
    JButton adminButton;
    JButton backButton;
    JButton searchEmployeeButton;
    JTextField employeeTextField;
    JLabel isInputValid;
    private TwoThreeTree tree;
    

    Font buttonFonts = new Font("Verdana", Font.PLAIN, 50);

    public  GUI(TwoThreeTree tree){
        this.tree = tree; 
      mainFrame = new JFrame("DAA Final Term");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setVisible(true);
      mainFrame.setSize(1524,864);
      mainFrame.setResizable(false);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.setLayout(null);
      
      welcomeMessage();
      interfaceButtons();
    }

    private void welcomeMessage() {
        JLabel managementMessage = new JLabel("Employee Management Dashboard");
        managementMessage.setFont(new Font("Verdana",Font.BOLD,60));
        managementMessage.setBounds(200, 50, 1500, 200);
        mainFrame.add(managementMessage);
    }

    private void interfaceButtons() {
        employeeButton = new JButton("Employee");
        adminButton = new JButton("Admin");
        employeeButton.setBounds(300, 300, 300, 100);
        employeeButton.setFont(buttonFonts);
        employeeButton.addActionListener(this);
        adminButton.setBounds(800, 300, 300, 100);
        adminButton.setFont(buttonFonts);
        adminButton.addActionListener(this);
        mainFrame.add(employeeButton);
        mainFrame.add(adminButton);
    }

    private void addBackButtons(){
        backButton = new JButton("Back");
        backButton.setBounds(1200, 700, 300, 100);
        backButton.setFont(buttonFonts);
        backButton.addActionListener(this);
        mainFrame.add(backButton);
    }

    

    private void replaceUI(int excemptions) {
        mainFrame.getContentPane().removeAll();
        if(excemptions==0){
            addBackButtons();
        }
        mainFrame.revalidate();
        mainFrame.repaint();
        throw new UnsupportedOperationException("Unimplemented method 'replaceUI'");
    }

    private void employeeUI(int type){
        mainFrame.getContentPane().removeAll();
        employeeTextField = new JTextField("Please Enter the employee no to proceed");
        employeeTextField.setBounds(500, 200, 300, 50);
        
        searchEmployeeButton = new JButton("Search");
        searchEmployeeButton.setBounds(900, 200, 100, 50);
        searchEmployeeButton.addActionListener(this);
        if(type ==1){
            JLabel isInputValid = new JLabel("");
            isInputValid.setBounds(500, 200, 300, 200);
            isInputValid.setText("Invalid Employee ID (Enter Numbers Only)");
            mainFrame.add(isInputValid);
        }
        
        
        
        mainFrame.add(searchEmployeeButton);
        mainFrame.add(employeeTextField);
        addBackButtons();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void EmployeeResult(Node resultNode){
        mainFrame.getContentPane().removeAll();
        JTextField resultEmployeeID = new JTextField();
        JTextField resultEmployeeName = new JTextField();
        JTextField resultEmployeeSalary = new JTextField();
        JTextField resultEmployeeDepartment = new JTextField();
        JTextField resultEmployeeJobDesc = new JTextField();

        resultEmployeeID.setBounds(100, 100, 500, 30);
        resultEmployeeName.setBounds(100, 200, 500, 30);
        resultEmployeeSalary.setBounds(100, 300, 500, 30);
        resultEmployeeDepartment.setBounds(100, 400, 500, 30);
        resultEmployeeJobDesc.setBounds(100, 500, 500, 30);

        
        Employee employee = resultNode.keys[0];
        resultEmployeeID.setText("Employee ID: " + employee.getEmpNo() );
        resultEmployeeName.setText("Name: "+ employee.getLastName()+ ", " +employee.getFirstName());
        resultEmployeeSalary.setText("Monthly Salary: " + employee.getSalary() );
        resultEmployeeDepartment.setText("Department: " + employee.getDepartment());
        resultEmployeeJobDesc.setText("Job Description: " + employee.getJobDesc());
        mainFrame.add(resultEmployeeID);
        mainFrame.add(resultEmployeeName);
        mainFrame.add(resultEmployeeSalary);
        mainFrame.add(resultEmployeeDepartment);
        mainFrame.add(resultEmployeeJobDesc);
        addBackButtons();
        mainFrame.revalidate();
        mainFrame.repaint();
    }


    public boolean inputSearchVerifyer(String str){
        return str.matches("\\d+");
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchEmployeeButton){
           
            if(inputSearchVerifyer(employeeTextField.getText())==true){
                
                int searchID = Integer.parseInt(employeeTextField.getText());
                Node resultNode = tree.search(searchID);
                if(tree.search(searchID)!=null){
                    EmployeeResult(resultNode);
                }
            }else{
                employeeUI(1);
            }
            
        }
        if (e.getSource() == employeeButton){
            employeeUI(0);
        }  
        if(e.getSource() == adminButton) {
            replaceUI(0);
        } 
        else if (e.getSource() == backButton) 
        {
                mainFrame.getContentPane().removeAll();
                welcomeMessage();
                interfaceButtons();
                mainFrame.revalidate();
                mainFrame.repaint();
        }
       
    }

}   
