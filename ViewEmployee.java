package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;  //sql package to form table
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener {

    private JTable table;
    private Choice employeeIdChoice;
    private JButton searchButton, printButton, updateButton, backButton;

    ViewEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchLabel = new JLabel("Search by Employee Id");
        searchLabel.setBounds(20, 20, 150, 30);
        add(searchLabel);

        employeeIdChoice = new Choice();
        employeeIdChoice.setBounds(180, 20, 150, 30);
        add(employeeIdChoice);

        try {
            Connect connection = new Connect();
            ResultSet rs = connection.s.executeQuery("SELECT * FROM employee_info");  // statement lega sql se
            while (rs.next()) {
                employeeIdChoice.add(rs.getString("Emp_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Connect connection = new Connect();
            ResultSet rs = connection.s.executeQuery("SELECT * FROM employee_info");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 1170, 658);
        add(scrollPane);

        searchButton = new JButton("Search");
        searchButton.setBounds(20, 70, 150, 30);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(180, 70, 150, 30);
        printButton.addActionListener(this);
        add(printButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(340, 70, 150, 30);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(500, 70, 150, 30);
        backButton.addActionListener(this);
        add(backButton);

        setSize(1200, 600);
        setLocation(150, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            String query = "SELECT * FROM employee_info WHERE Emp_ID = '" + employeeIdChoice.getSelectedItem() + "'";
            try {
                Connect connection = new Connect();
                ResultSet rs = connection.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));  // sql ke andar ek package hai dbutils
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == printButton) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateButton) {
            setVisible(false);
            new UpdateEmployee(employeeIdChoice.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
