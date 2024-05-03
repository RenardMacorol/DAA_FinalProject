package userInteface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener{
    JFrame mainFrame;
    JButton employeeButton;
    JButton adminButton;
    JButton backButton;
    Font buttonFonts = new Font("Verdana", Font.PLAIN, 50);

    public GUI(){
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
        backButton.setBounds(600, 500, 300, 100);
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

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == employeeButton || e.getSource() == adminButton) {
                replaceUI(0);
        } else if (e.getSource() == backButton) {
                mainFrame.getContentPane().removeAll();
                welcomeMessage();
                interfaceButtons();
                mainFrame.revalidate();
                mainFrame.repaint();
        }
       
    }

}   
