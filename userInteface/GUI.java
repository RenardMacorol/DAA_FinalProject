package userInteface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;


import javax.swing.table.DefaultTableModel;

import dataStructure.*;
import employeePackage.Employee;


public class GUI implements ActionListener{
    JFrame mainFrame;
    JButton employeeButton;
    JButton adminButton;
    JButton backButton;
    JButton searchEmployeeButton;
    JButton adminInsertButton;
    JButton adminDeleteButoon;
    JButton adminVisualButton;
    JTextField employeeTextField;
    JLabel isInputValid;
    private TwoThreeTree tree;
    private EmployeeDA employeeDA;
    
    
    DecimalFormat decimalFormat = new DecimalFormat("$###.00");
    Font buttonFonts = new Font("Verdana", Font.PLAIN, 50);
    private JButton adminUpdateButton;
    private JButton adminGenerateButton;

    public  GUI(TwoThreeTree tree, EmployeeDA employeeDA){
        this.tree = tree; 
        this.employeeDA = employeeDA;
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

    

    private void visualizeTree() {
        mainFrame.getContentPane().removeAll();
        
        mainFrame.revalidate();
        mainFrame.repaint();
        
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
        }if(type ==2){
            JLabel isInputValid = new JLabel("");
            isInputValid.setBounds(500, 200, 300, 200);
            isInputValid.setText("Employee Not Found");
            mainFrame.add(isInputValid);
        }
        
        
        
        mainFrame.add(searchEmployeeButton);
        mainFrame.add(employeeTextField);
        addBackButtons();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void EmployeeResult(Node resultNode,int searchID){
        mainFrame.getContentPane().removeAll();
        JTextField resultEmployeeID = new JTextField();
        JTextField resultEmployeeName = new JTextField();
        JTextField resultEmployeeSalary = new JTextField();
        JTextField resultEmployeeDepartment = new JTextField();
        JTextField resultEmployeeJobDesc = new JTextField();

        resultEmployeeID.setBounds(100, 100, 500, 30);
        resultEmployeeID.setEditable(false);
        resultEmployeeName.setBounds(100, 200, 500, 30);
        resultEmployeeName.setEditable(false);
        resultEmployeeSalary.setBounds(100, 300, 500, 30);
        resultEmployeeSalary.setEditable(false);
        resultEmployeeDepartment.setBounds(100, 400, 500, 30);
        resultEmployeeDepartment.setEditable(false);
        resultEmployeeJobDesc.setBounds(100, 500, 500, 30);
        resultEmployeeJobDesc.setEditable(false);
        for(int i=0;i < resultNode.numKeys; i++){
            Employee employee = resultNode.keys[i];
            if(employee.getEmpNo() == searchID){
                resultEmployeeID.setText("Employee ID: " + employee.getEmpNo() );
                resultEmployeeName.setText("Name: "+ employee.getLastName()+ ", " +employee.getFirstName());
                resultEmployeeSalary.setText("Monthly Salary: " + decimalFormat.format(employee.getSalary()) );
                resultEmployeeDepartment.setText("Department: " + employee.getDepartment());
                resultEmployeeJobDesc.setText("Job Description: " + employee.getJobDesc());
            }
        }
        
        
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

    public void adminUI(int type){
        mainFrame.getContentPane().removeAll();
        employeeTextField = new JTextField("Please Enter the employee no to proceed");
        employeeTextField.setBounds(200, 20, 300, 50);
        
        searchEmployeeButton = new JButton("Search");
        searchEmployeeButton.setBounds(500, 20, 100, 50);
        searchEmployeeButton.addActionListener(this);

        adminInsertButton = new JButton("Insert new Employee");
        adminInsertButton.setBounds(600, 20, 200, 50);
        adminInsertButton.addActionListener(this);
        
        adminDeleteButoon = new JButton("Delete");
        adminDeleteButoon.setBounds(700, 20, 100, 50);
        adminDeleteButoon.addActionListener(this);

        adminVisualButton = new JButton("Visual Tree");
        adminVisualButton.setBounds(800, 20, 100, 50);
        adminVisualButton.addActionListener(this);

        adminUpdateButton = new JButton("Update Employee");
        adminUpdateButton.setBounds(900, 20, 200, 50);
        adminUpdateButton.addActionListener(this);

        adminGenerateButton = new JButton("Generate Report");
        adminGenerateButton.setBounds(1100, 20, 200, 50);
        adminGenerateButton.addActionListener(this);
        
        if(type ==1){
            JLabel isInputValid = new JLabel("");
            isInputValid.setBounds(500, 200, 300, 200);
            isInputValid.setText("Invalid Employee ID (Enter Numbers Only)");
            mainFrame.add(isInputValid);
        }

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells uneditable
            }
        };
        
        JTable table = new JTable(tableModel);

        // Add columns to the table
        tableModel.addColumn("Employee ID");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Salary");
        tableModel.addColumn("Department");
        tableModel.addColumn("Job Description");

        Object[][] employeeData = getEmployeeDataFromTree(tree);
        for (Object[] row : employeeData) {
            tableModel.addRow(row);
        }
    
        // Add the table to a scroll pane and set its bounds
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 1400, 600);

        mainFrame.add(adminGenerateButton);
        mainFrame.add(adminUpdateButton);
        mainFrame.add(adminVisualButton);
        mainFrame.add(scrollPane);
        mainFrame.add(adminInsertButton);
        mainFrame.add(adminDeleteButoon);
        mainFrame.add(searchEmployeeButton);
        mainFrame.add(employeeTextField);
        addBackButtons();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchEmployeeButton) {
            // Handle search action
            if (inputSearchVerifyer(employeeTextField.getText())) {
                int searchID = Integer.parseInt(employeeTextField.getText());
                Node resultNode = tree.search(searchID);
                if (resultNode != null) {
                    EmployeeResult(resultNode, searchID);
                }else{
                    employeeUI(2);
                }
            } else {
                employeeUI(1);
            }
        } else if (e.getSource() == employeeButton) {
            // Handle employee button action
            employeeUI(0);
        } else if (e.getSource() == adminButton) {
            // Handle admin button action
            adminUI(0);
        } else if (e.getSource() == adminInsertButton) {
            // Handle admin insert button action
            int latestEmpNo = employeeDA.getLatestEmpNo(); // lites empNO shuta
            new InsertEmpGUI(latestEmpNo); 
        }else if (e.getSource() == adminGenerateButton) {
            // Handle employee button action
            GenerateReportUI generate = new GenerateReportUI(mainFrame,tree);
        }  else if (e.getSource() == adminUpdateButton) {
            UpdateEmpGUI updateEmpGUI = new UpdateEmpGUI(mainFrame, tree,decimalFormat);
        } else if (e.getSource() == backButton) {
            // Handle back button action
            mainFrame.getContentPane().removeAll();
            welcomeMessage();
            interfaceButtons();
            mainFrame.revalidate();
            mainFrame.repaint();
        }
    }
    


    public Object[][] getEmployeeDataFromTree(TwoThreeTree tree) {
        int numEmployees = tree.countEmployees();
        // Initialize an array to hold the employee data
        Object[][] employeeData = new Object[numEmployees][6];
        
        // Traverse the tree and collect employee data
        collectEmployeeData(tree.root, employeeData, 0);
        
        return employeeData;
    }
    
    // Helper method to calculate the size of the tree
    private int treeSize(TwoThreeTree tree) {
        return treeSizeHelper(tree.root);
    }
    
    private int treeSizeHelper(Node node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < node.numKeys; i++) {
            count += treeSizeHelper(node.children[i]);
        }
        count += node.numKeys;
        return count;
    }
    
    // Helper method to collect employee data recursively
private int collectEmployeeData(Node node, Object[][] employeeData, int index) {
    if (node == null) {
        return index;
    }

    for (int i = 0; i < node.numKeys; i++) {
        Employee employee = node.keys[i];
        if (index < employeeData.length && i < employeeData[index].length) {
            employeeData[index][0] = employee.getEmpNo();
            employeeData[index][1] = employee.getLastName();
            employeeData[index][2] = employee.getFirstName();
            employeeData[index][3] = decimalFormat.format(employee.getSalary());
            employeeData[index][4] = employee.getDepartment();
            employeeData[index][5] = employee.getJobDesc();
            index++;
        } else {
            // Handle case when the array dimensions are not enough
            System.err.println("Array dimensions are not enough to accommodate all employees.");
            return index;
        }
    }

    for (int i = 0; i < node.numKeys + 1; i++) {
        index = collectEmployeeData(node.children[i], employeeData, index);
    }

    return index;
}

    

}   
