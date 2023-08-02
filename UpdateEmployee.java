package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField educationField, guardianNameField, guardianContactField, salaryField, addressField, phoneField, emailField, designationField, lblAadhar;

    JLabel lbl_empId;
    JButton updateButton, backButton;

    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("C059", Font.BOLD, 35));
        add(heading);

        JLabel employeeNameLabel = new JLabel("Name:");
        employeeNameLabel.setBounds(30, 150, 150, 30);
        employeeNameLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(employeeNameLabel);

        JLabel lblName = new JLabel();
        lblName.setBounds(250, 150, 200, 30);
        add(lblName);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(520, 150, 500, 30);
        dobLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(dobLabel);

        JLabel lblDob = new JLabel();
        lblDob.setBounds(760, 150, 200, 30);
        add(lblDob);

        JLabel guardianNameLabel = new JLabel("Guardian's Name:");
        guardianNameLabel.setBounds(30, 200, 400, 30);
        guardianNameLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(guardianNameLabel);

        guardianNameField = new JTextField();
        guardianNameField.setBounds(250, 200, 200, 30);
        add(guardianNameField);

        JLabel guardianContactLabel = new JLabel("Guardian's Contact:");
        guardianContactLabel.setBounds(520, 200, 200, 30);
        guardianContactLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(guardianContactLabel);

        guardianContactField = new JTextField();
        guardianContactField.setBounds(760, 200, 200, 30);
        add(guardianContactField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(30, 250, 200, 30);
        salaryLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(250, 250, 200, 30);
        add(salaryField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(520, 250, 200, 30);
        addressLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(760, 250, 200, 30);
        add(addressField);

        JLabel phoneLabel = new JLabel("Contact:");
        phoneLabel.setBounds(30, 300, 200, 30);
        phoneLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(250, 300, 200, 30);
        add(phoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(520, 300, 200, 30);
        emailLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(760, 300, 200, 30);
        add(emailField);

        JLabel educationLabel = new JLabel("Highest Education:");
        educationLabel.setBounds(30, 350, 200, 30);
        educationLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(educationLabel);

        educationField = new JTextField();
        educationField.setBackground(Color.WHITE);
        educationField.setBounds(250, 350, 200, 30);
        add(educationField);

        JLabel designationLabel = new JLabel("Designation:");
        designationLabel.setBounds(520, 350, 200, 30);
        designationLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(designationLabel);

        designationField = new JTextField();
        designationField.setBounds(760, 350, 200, 30);
        add(designationField);

        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setBounds(30, 400, 200, 30);
        aadharLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(aadharLabel);

        JLabel lblAadhar = new JLabel();
        lblAadhar.setBounds(250, 400, 200, 30);
        add(lblAadhar);

        JLabel empIdLabel = new JLabel("Employee id:");
        empIdLabel.setBounds(520, 400, 200, 30);
        empIdLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(empIdLabel);

        lbl_empId = new JLabel();
        lbl_empId.setBounds(800, 400, 200, 30);
        lbl_empId.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(lbl_empId);

        try {
            Connect c = new Connect();
            String query = "SELECT * FROM employee_info WHERE Emp_ID='" + empId + "';";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblName.setText(rs.getString("Name"));
                lblDob.setText(rs.getString("DOB"));
                guardianNameField.setText(rs.getString("Guardian_Name"));
                guardianContactField.setText(rs.getString("Guardian_Contact"));
                salaryField.setText(rs.getString("Salary"));
                addressField.setText(rs.getString("Address"));
                phoneField.setText(rs.getString("Phone"));
                emailField.setText(rs.getString("Email"));
                educationField.setText(rs.getString("Education"));
                designationField.setText(rs.getString("Designation"));
                lblAadhar.setText(rs.getString("Adhaar"));
                lbl_empId.setText(rs.getString("Emp_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateButton = new JButton("Update Details");
        updateButton.setBounds(300, 500, 200, 40);
        updateButton.addActionListener(this);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(600, 500, 200, 40);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(backButton);

        setSize(1200, 600);
        setLocation(150, 100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            String guardianName = guardianNameField.getText();
            String guardianContact = guardianContactField.getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String education = educationField.getText();
            String designation = designationField.getText();

            try {
                Connect conn = new Connect();
                String query = "UPDATE employee_info SET Guardian_Name='" + guardianName + "',Guardian_Contact='" + guardianContact + "',Salary=" + salary + ",Address='" + address + "',Phone=" + phone + ",Email='" + email + "',Education='" + education + "',Designation='" + designation + "' WHERE Emp_ID='" + empId + "';";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("error");
    }
}
