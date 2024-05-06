package userInteface;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;


import dataStructure.TwoThreeTree;

public class GenerateReportUI {
    GenerateReportUI(JFrame frame,TwoThreeTree tree){
        Font reportFont  = new Font("Verdana", Font.BOLD, 30);
        Font titleFont  = new Font("Verdana", Font.BOLD, 50);
        DecimalFormat decimalFormat = new DecimalFormat("$###,###.00");
        frame.getContentPane().removeAll();
        double totalSalary = tree.countSalary();
        JLabel generateReport = new JLabel("Company Generated Report");
        JLabel totalSalaryMonthly = new JLabel("Total Salary Monthly: "+ decimalFormat.format(totalSalary));
        JLabel totalSalaryYearly = new JLabel("Total Salary Yearly: "+ decimalFormat.format(totalSalary*12) );
        JLabel totalEmployee = new JLabel("Total Employees: "+ tree.countEmployees());
        JLabel meanSalary = new JLabel("Mean salary: "+ decimalFormat.format(tree.countSalary()/tree.countEmployees()));
        JLabel medianSalary = new JLabel("Median salary: "+ decimalFormat.format(tree.getMedianSalary()));
        
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

        frame.add(generateReport);
        frame.add(totalSalaryMonthly);
        frame.add(totalSalaryYearly);
        frame.add(totalEmployee);
        frame.add(meanSalary);
        frame.add(medianSalary);
        
        frame.revalidate();
        frame.repaint();
    }

    

    
}
