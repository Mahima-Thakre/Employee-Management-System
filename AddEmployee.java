package Employee_Management;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    private Random random = new Random();
    private int number = random.nextInt(9999);
    private JTextField nameField, guardianNameField, guardianContactField, salaryField, addressField, phoneField, emailField, designationField, aadharField;
    private JDateChooser dob;
    private JComboBox<String> education;
    private JLabel empIdLabel;
    private JButton addButton, backButton;

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel headingLabel = new JLabel("Add Employee Detail");
        headingLabel.setBounds(320, 30, 500, 50);
        headingLabel.setFont(new Font("C059", Font.BOLD, 35));
        add(headingLabel);

        JLabel employeeNameLabel = new JLabel("Name:");
        employeeNameLabel.setBounds(30, 150, 150, 30);
        employeeNameLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(employeeNameLabel);

        nameField = new JTextField();
        nameField.setBounds(250, 150, 200, 30);
        add(nameField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(520, 150, 500, 30);
        dobLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(dobLabel);

        dob = new JDateChooser();
        dob.setBounds(760, 150, 200, 30);
        add(dob);

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

        String[] courses = {"12th", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        education = new JComboBox<>(courses);
        education.setBackground(Color.WHITE);
        education.setBounds(250, 350, 200, 30);
        add(education);

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

        aadharField = new JTextField();
        aadharField.setBounds(250, 400, 200, 30);
        add(aadharField);

        JLabel empIdLabel = new JLabel("Employee id:");
        empIdLabel.setBounds(520, 400, 200, 30);
        empIdLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(empIdLabel);

        this.empIdLabel = new JLabel(" " + number + " ");
        this.empIdLabel.setBounds(800, 400, 200, 30);
        this.empIdLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(this.empIdLabel);

        addButton = new JButton("Add Details");
        addButton.setBounds(300, 500, 200, 40);
        addButton.addActionListener(this);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
        add(addButton);

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
        if (ae.getSource() == addButton) {
            String name = nameField.getText();
            String guardianName = guardianNameField.getText();
            String guardianContact = guardianContactField.getText();
            String dob = ((JTextField) this.dob.getDateEditor().getUiComponent()).getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String educationLevel = (String) education.getSelectedItem();
            String designation = designationField.getText();
            String aadhar = aadharField.getText();
            String empId = empIdLabel.getText();

            try {
                Connect connection = new Connect();
                String query = "INSERT INTO employee_info VALUES('" + empId + "','" + name + "','" + guardianName + "','" + guardianContact + "','" + dob + "'," + salary + ",'" + address + "','" + phone + "','" + email + "','" + educationLevel + "','" + designation + "'," + aadhar + ")";
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        new AddEmployee();
    }
}
