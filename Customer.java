package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.jar.JarEntry;

class Customer implements ActionListener{
    private JFrame frame;
    private JButton welcomeButton;
    private JButton cashierButton;
    private static int counter = 0;
    private static JLabel qtyText;

    Customer(JFrame frame){
        this.frame = frame;

        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setBounds(340, 40, 450, 100);
        welcomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
        frame.add(welcomeLabel);

        JPanel background = new JPanel();
        background.setBounds(0, 0, 1000, 900);
        background.setBackground(Color.decode("#475C7A"));
        frame.add(background);

        welcomeButton = new JButton("CLICK HERE TO ORDER");
        welcomeButton.setBounds(306, 383, 388, 133);
        welcomeButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        welcomeButton.setBackground(Color.decode("#FFFFFF"));
        welcomeButton.addActionListener(this);
        frame.add(welcomeButton);

        cashierButton = new JButton("FOR CASHIER ONLY!!");
        cashierButton.setBounds(400, 750, 200, 40);
        cashierButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cashierButton.setBackground(Color.decode("#FFFFFF"));
        cashierButton.addActionListener(this);
        frame.add(cashierButton);

        frame.setVisible(true);
    }

    static void orderPanel(JFrame frame){
        JPanel orderPagePanel = new JPanel(null);
        orderPagePanel.setBounds(0, 0, 1000, 900);
        orderPagePanel.setBackground(Color.decode("#475C7A"));
        frame.add(orderPagePanel);

        JTabbedPane menuTab = new JTabbedPane();
        menuTab.setBounds(43, 121, 594, 722);
        orderPagePanel.add(menuTab);

        JPanel mainDish = new JPanel(null);
        JButton dish1 = new JButton("Fried Chicken");
        dish1.setBounds(40, 40, 115, 115);
        dish1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dish1.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(dish1);
        menuTab.add("Main Dish", mainDish);

        JButton increaseButton = new JButton("+");
        increaseButton.setBounds(160, 40, 45, 45);
        increaseButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        increaseButton.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(increaseButton);

        JButton decreaseButton = new JButton("-");
        decreaseButton.setBounds(160, 80, 45, 45);
        decreaseButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        decreaseButton.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(decreaseButton);

        JLabel dish1Price = new JLabel("$1.99");
        dish1Price.setBounds(80, 150, 100, 30);
        dish1Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        mainDish.add(dish1Price);

        JPanel sideDish = new JPanel();
        menuTab.add("Side Dish", sideDish);

        JPanel beverage = new JPanel();
        menuTab.add("Beverage", beverage);

        JPanel dessert = new JPanel();
        menuTab.add("Dessert", dessert);

        JLabel orderListLabel = new JLabel("Orders");
        orderListLabel.setBounds(664, 123, 100, 20);
        orderListLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        orderListLabel.setForeground(Color.white);
        orderPagePanel.add(orderListLabel);

        JPanel orderList = new JPanel(null);
        orderList.setBounds(664, 142, 306, 560);
        orderPagePanel.add(orderList);

        JLabel tableItem = new JLabel("Item");
        tableItem.setBounds(0, 0, 300, 20);
        tableItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(tableItem);

        JLabel tableQty = new JLabel("Quantity");
        tableQty.setBounds(130, 0, 300, 20);
        tableQty.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(tableQty);

        JLabel tablePrice = new JLabel("Price");
        tablePrice.setBounds(280, 0, 300, 20);
        tablePrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(tablePrice);

        qtyText = new JLabel();
        qtyText.setBounds(130, 20, 300, 20);
        qtyText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(qtyText);

        increaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter++;
                qtyText.setText(Integer.toString(counter));
            }
        });
    
        decreaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (counter > 0) {
                    counter--;
                    qtyText.setText(Integer.toString(counter));
                }
            }
        });
    

        JLabel getDish1 = new JLabel();
        getDish1.setBounds(5, 20, 200, 20);
        getDish1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(getDish1);
        JLabel getDish1Price = new JLabel();
        getDish1Price.setBounds(270, 20, 100, 20);
        getDish1Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(getDish1Price);
        dish1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                getDish1.setText(dish1.getText());
                getDish1Price.setText(dish1Price.getText());
            }
        });



        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == welcomeButton){
            clearFrame(frame);
            orderPanel(frame);
        }else if(event.getSource() == cashierButton){
            clearFrame(frame);
            new Cashier(frame);
        }
    }

    static void clearFrame(JFrame frame){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.validate();
    }
}
