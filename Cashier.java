package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.ListIterator;

class Cashier implements ActionListener{
    private JFrame frame;
    private JButton loginBtn;
    private JTextField usernameText;
    private JPasswordField passwordText;

    Cashier(JFrame frame){
        this.frame = frame;

        JPanel loginBackground = new JPanel(null);
        loginBackground.setBounds(0, 0, 1000, 900);
        loginBackground.setBackground(Color.decode("#475C7A"));
        frame.add(loginBackground);

        JLabel welcome = new JLabel();
        welcome.setForeground(Color.white);
        Components.addLabel(welcome, loginBackground, "WELCOME", 340, 40, 450, 100, 60);

        JLabel usernameLabel = new JLabel();
        usernameLabel.setForeground(Color.white);
        Components.addLabel(usernameLabel, loginBackground, "USERNAME", 400, 230, 100, 15, 14);

        usernameText = new JTextField();
        usernameText.setBounds(400, 260, 200, 30);
        usernameText.setBackground(Color.white);
        loginBackground.add(usernameText);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setForeground(Color.white);
        Components.addLabel(passwordLabel, loginBackground, "PASSWORD", 400, 330, 100, 15, 14);

        passwordText = new JPasswordField();
        passwordText.setBounds(400, 360, 200, 30);
        passwordText.setBackground(Color.white);
        loginBackground.add(passwordText);

        loginBtn = new JButton("LOGIN");
        Components.addButton(loginBtn, loginBackground, 400, 480, 200, 50, 12);
        loginBtn.addActionListener(this);

        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == loginBtn){
            String username = usernameText.getText();
            String password = new String(passwordText.getPassword());

            if ("yourUsername".equals(username) && "yourPassword".equals(password)) {
                checkOrders(frame);
            } else {
                JOptionPane.showMessageDialog(frame, "Login Failed. Invalid username or password.");
            }

            usernameText.setText("");
            passwordText.setText("");
        }
    }

    static void checkOrders(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
    
        JPanel orderPanel = new JPanel(null);
        orderPanel.setSize(1000, 900);
        orderPanel.setBackground(Color.decode("#475C7A"));
        frame.add(orderPanel);
    
        JLabel orderLabel = new JLabel("CHECK ORDERS");
        orderLabel.setBounds(339, 70, 500, 62);
        orderPanel.add(orderLabel);
    
        JTextArea ordersTextArea = new JTextArea();
        ordersTextArea.setBounds(100, 150, 800, 250);
        orderPanel.add(ordersTextArea);
    
        try {
            List<String> orders = Files.readAllLines(Paths.get(Customer.getFolderPath(), "orders.dat"));
            for (String order : orders) {
                ordersTextArea.append(order + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error reading orders from file.");
        }
    
        JButton paidButton = new JButton("Paid");
        paidButton.setBounds(500, 450, 100, 30);
        orderPanel.add(paidButton);
    
        JButton backButton = new JButton("BACK TO LOGIN");
        backButton.setBounds(260, 450, 200, 30);
        orderPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                Customer.clearFrame(frame);
                new Customer(frame);
            }
        });
    
        paidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Path ordersFilePath = Paths.get(Customer.getFolderPath(), "orders.dat");
                    List<String> orders = Files.readAllLines(ordersFilePath);
        
                    String receiptToRemove = "";
                    boolean foundReceipt = false;
        
                    for (int i = 0; i < orders.size(); i++) {
                        if (orders.get(i).startsWith(receiptToRemove) && !orders.get(i).trim().isEmpty()) {
                            foundReceipt = true;
        
                            // Remove the entire receipt, including any following empty lines
                            while (i < orders.size() && !orders.get(i).isEmpty()) {
                                orders.remove(i);
                            }
                            break;
                        }
                    }
        
                    if (foundReceipt) {
                        Files.write(ordersFilePath, orders, StandardOpenOption.TRUNCATE_EXISTING);
        
                        ordersTextArea.setText("");
                        for (String order : orders) {
                            if (!order.trim().isEmpty()) {
                                ordersTextArea.append(order + "\n");
                            }
                        }
        
                        JOptionPane.showMessageDialog(frame, "Receipt marked as paid and removed.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Receipt not found.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error removing receipt from file.");
                }
            }
        });
        
                

        frame.setVisible(true);
    }
}