package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JFrame homeFrame;

    JButton addButton, viewButton, removeButton, updateButton;

    Home() {
        homeFrame = new JFrame();
        homeFrame.setContentPane(new ImagePanel3());
        homeFrame.setLayout(null);
        homeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        homeFrame.setResizable(false);

        JLabel headingLabel = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        headingLabel.setBounds(50, 50, 800, 50);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
        headingLabel.setForeground(Color.WHITE);
        homeFrame.add(headingLabel);

        addButton = new JButton("ADD EMPLOYEE");
        addButton.setBounds(100, 150, 200, 50);
        addButton.setBackground(Color.DARK_GRAY);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        homeFrame.add(addButton);

        viewButton = new JButton("VIEW EMPLOYEES");
        viewButton.setBounds(350, 150, 200, 50);
        viewButton.setBackground(Color.DARK_GRAY);
        viewButton.setForeground(Color.WHITE);
        viewButton.addActionListener(this);
        homeFrame.add(viewButton);

        updateButton = new JButton("UPDATE ");
        updateButton.setBounds(100, 250, 200, 50);
        updateButton.setBackground(Color.DARK_GRAY);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);
        homeFrame.add(updateButton);

        removeButton = new JButton("REMOVE ");
        removeButton.setBounds(350, 250, 200, 50);
        removeButton.setBackground(Color.DARK_GRAY);
        removeButton.setForeground(Color.WHITE);
        removeButton.addActionListener(this);
        homeFrame.add(removeButton);

        homeFrame.setSize(1200, 600);
        homeFrame.setLocation(150, 100);
        homeFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            homeFrame.setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == viewButton) {
            homeFrame.setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == updateButton) {
            homeFrame.setVisible(false);
            new ViewEmployee();
        } else {
            homeFrame.setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String args[]) {
        new Home();
    }
}

class ImagePanel3 extends JPanel {
    public void paintComponent(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("Employee_Management/Images/image_3.jpg");
        g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
