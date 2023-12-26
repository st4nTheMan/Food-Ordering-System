package system;

import javax.swing.*;
import java.awt.*;

class Cashier{
    private JFrame frame;

    Cashier(JFrame frame){
        this.frame = frame;

        JPanel loginBackground = new JPanel(null);
        loginBackground.setBounds(0, 0, 1000, 900);
        loginBackground.setBackground(Color.decode("#475C7A"));
        frame.add(loginBackground);

        JLabel welcome = new JLabel("WELCOME");
        welcome.setBounds(340, 40, 450, 100);
        welcome.setFont(new Font("Times New Roman", Font.PLAIN, 60));
        welcome.setForeground(Color.white);
        loginBackground.add(welcome);

        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setBounds(400, 230, 100, 15);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.white);
        loginBackground.add(usernameLabel);

        JTextField usernameText = new JTextField();
        usernameText.setBounds(400, 260, 200, 30);
        usernameText.setBackground(Color.white);
        loginBackground.add(usernameText);

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(400, 330, 100, 15);
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.white);
        loginBackground.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(400, 360, 200, 30);
        passwordText.setBackground(Color.white);
        loginBackground.add(passwordText);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(400, 480, 200, 50);
        loginBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        loginBtn.setBackground(Color.decode("#FFFFFF"));
        loginBackground.add(loginBtn);

        frame.setVisible(true);
    }
}