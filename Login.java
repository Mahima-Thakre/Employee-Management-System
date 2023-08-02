package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JFrame frame;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;

    Login() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setContentPane(new ImagePanel2());
        frame.setLayout(null);
        frame.setResizable(false);

        JLabel usernameLabel = new JLabel("Username:"); // User name
        usernameLabel.setBounds(50, 200, 200, 50);
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        usernameLabel.setForeground(Color.WHITE);
        frame.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(275, 210, 200, 40);
        usernameField.setFont(new Font("Times New Roman", Font.BOLD, 28)); // Text field for username
        frame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:"); // User password
        passwordLabel.setBounds(50, 300, 200, 50);
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        passwordLabel.setForeground(Color.WHITE);
        frame.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(275, 310, 200, 40);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 28)); // Text field for password
        frame.add(passwordField);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(450, 425, 200, 50);
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 32));
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        frame.add(loginButton);

        frame.setSize(1200, 600);
        frame.setLocation(150, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = usernameField.getText();
            String password = passwordField.getText();

            Connect connection = new Connect();
            String query = "SELECT * FROM Login WHERE Username = '" + username + "' AND Password = '" + password + "'";

            ResultSet rs = connection.s.executeQuery(query);

            if (rs.next()) {
                frame.setVisible(false); // Go to the next class
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}

class ImagePanel2 extends JPanel {
    public void paintComponent(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("Employee_Management/Images/image_2.jpg");
        g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
