package Employee_Management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice empIdChoice;
    JButton deleteButton, backButton;

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1200, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(150, 100);

        JLabel empIdLabel = new JLabel("Employee ID");
        empIdLabel.setBounds(50, 50, 150, 50);
        empIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(empIdLabel);

        empIdChoice = new Choice();
        empIdChoice.setBounds(225, 65, 100, 100);
        add(empIdChoice);

        try {
            Connect c = new Connect();
            String query = "SELECT * FROM employee_info;";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                empIdChoice.add(rs.getString("Emp_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 150, 150, 50);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(nameLabel);

        JLabel lblName = new JLabel();
        lblName.setBounds(225, 150, 250, 50);
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(lblName);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(50, 225, 150, 50);
        phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(phoneLabel);

        JLabel lblPhone = new JLabel();
        lblPhone.setBounds(225, 225, 250, 50);
        lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(lblPhone);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 300, 150, 50);
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(emailLabel);

        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(225, 300, 250, 50);
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(lblEmail);

        try {
            Connect c = new Connect();
            String query = "SELECT * FROM employee_info WHERE Emp_ID='" + empIdChoice.getSelectedItem() + "';";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblName.setText(rs.getString("Name"));
                lblPhone.setText(rs.getString("Phone"));
                lblEmail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        empIdChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Connect c = new Connect();
                    String query = "SELECT * FROM employee_info WHERE Emp_ID='" + empIdChoice.getSelectedItem() + "';";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblName.setText(rs.getString("Name"));
                        lblPhone.setText(rs.getString("Phone"));
                        lblEmail.setText(rs.getString("Email"));
                    }
                } catch (Exception ie) {
                    ie.printStackTrace();
                }
            }
        });

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(300, 450, 200, 40);
        deleteButton.addActionListener(this);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(deleteButton);

        backButton = new JButton("Back");
        backButton.setBounds(600, 450, 200, 40);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            try {
                Connect c = new Connect();
                String query = "DELETE FROM employee_info WHERE Emp_Id='" + empIdChoice.getSelectedItem() + "';";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Information deleted successfully");
                setVisible(false);
                new Home();
            } catch (Exception x) {
                x.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
