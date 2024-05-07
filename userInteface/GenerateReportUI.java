package userInteface;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;


import dataStructure.TwoThreeTree;

public class GenerateReportUI {
    JFrame mainFrame;
    TwoThreeTree tree;
    double totalSalary;
    JLabel generateReport;
    JLabel totalSalaryMonthly;
    JLabel totalSalaryYearly;
    JLabel totalEmployee;
    JLabel meanSalary;
    JLabel medianSalary;
    GenerateReportUI(TwoThreeTree tree){
        mainFrame = new JFrame("DAA Final Term");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(1524, 864);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        Font reportFont  = new Font("Verdana", Font.BOLD, 30);
        Font titleFont  = new Font("Verdana", Font.BOLD, 50);
        DecimalFormat decimalFormat = new DecimalFormat("$###,###.00");
        
        totalSalary = tree.countSalary();
        generateReport = new JLabel("Company Generated Report");
        totalSalaryMonthly = new JLabel("Total Salary Monthly: "+ decimalFormat.format(totalSalary));
        totalSalaryYearly = new JLabel("Total Salary Yearly: "+ decimalFormat.format(totalSalary*12) );
        totalEmployee = new JLabel("Total Employees: "+ tree.countEmployees());
        meanSalary = new JLabel("Mean salary: "+ decimalFormat.format(tree.countSalary()/tree.countEmployees()));
        medianSalary = new JLabel("Median salary: "+ decimalFormat.format(tree.getMedianSalary()));
        
        generateReport.setBounds(300, -150, 1000, 500);
        totalSalaryMonthly.setBounds(200, 20, 800, 300);
        totalSalaryYearly.setBounds(200, 80, 800, 300);
        totalEmployee.setBounds(200, 120, 500, 300);
        meanSalary.setBounds(200, 150, 800, 300);
        medianSalary.setBounds(200, 180, 500, 300);
        

        generateReport.setFont(titleFont);
        totalSalaryMonthly.setFont(reportFont);
        totalSalaryYearly.setFont(reportFont);
        totalEmployee.setFont(reportFont);
        meanSalary.setFont(reportFont);
        medianSalary.setFont(reportFont);

        mainFrame.add(generateReport);
        mainFrame.add(totalSalaryMonthly);
        mainFrame.add(totalSalaryYearly);
        mainFrame.add(totalEmployee);
        mainFrame.add(meanSalary);
        mainFrame.add(medianSalary);
        
      
    }
    

     

    

    
}
