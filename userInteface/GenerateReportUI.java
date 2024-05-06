package userInteface;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dataStructure.TwoThreeTree;

public class GenerateReportUI {
    GenerateReportUI(JFrame frame,TwoThreeTree tree){
        frame.getContentPane().removeAll();
        double totalSalary = tree.countSalary();
        JLabel totalSalaryMonthly = new JLabel("Total Salary Monthly "+ totalSalary);
        JLabel totalSalaryYearly = new JLabel("Total Salary Yearly "+ totalSalary*12 );
        totalSalaryMonthly.setBounds(200, 20, 300, 300);
        totalSalaryYearly.setBounds(200, 30, 300, 300);

        frame.add(totalSalaryMonthly);
        frame.add(totalSalaryYearly);
        frame.revalidate();
        frame.repaint();
    }
}
