package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton clickHereButton;

    public FirstPage() {
        frame = new JFrame();
        frame.setSize(1200, 600);
        frame.setLocation(150, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setContentPane(new ImagePanel1());
        frame.setResizable(false);
        frame.setLayout(null);

        clickHereButton = new JButton("CLICK HERE TO LOGIN");
        clickHereButton.setBounds(400, 400, 300, 70);
        clickHereButton.setBackground(Color.DARK_GRAY);
        clickHereButton.setForeground(Color.WHITE);
        clickHereButton.addActionListener(this);
        frame.add(clickHereButton);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        frame.setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new FirstPage();
    }
}

class ImagePanel1 extends JPanel {
    public void paintComponent(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("Employee_Management/Images/image_1.jpg");
        g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
