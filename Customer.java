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

        JLabel dish1Price = new JLabel("$1.99");
        dish1Price.setBounds(80, 150, 100, 30);
        dish1Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        mainDish.add(dish1Price);

        JButton increaseButton1 = new JButton("+");
        increaseButton1.setBounds(160, 40, 45, 45);
        increaseButton1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        increaseButton1.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(increaseButton1);

        JButton decreaseButton1 = new JButton("-");
        decreaseButton1.setBounds(160, 80, 45, 45);
        decreaseButton1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        decreaseButton1.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(decreaseButton1);

        JButton dish2 = new JButton("Spags");
        dish2.setBounds(40, 200, 115, 115);
        dish2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dish2.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(dish2);

        JLabel dish2Price = new JLabel("$2.99");
        dish2Price.setBounds(80, 310, 100, 30);
        dish2Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        mainDish.add(dish2Price);

        JButton increaseButton2 = new JButton("+");
        increaseButton2.setBounds(160, 200, 45, 45);
        increaseButton2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        increaseButton2.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(increaseButton2);

        JButton decreaseButton2 = new JButton("-");
        decreaseButton2.setBounds(160, 240, 45, 45);
        decreaseButton2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        decreaseButton2.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(decreaseButton2);

        JButton dish3 = new JButton("Canton");
        dish3.setBounds(40, 360, 115, 115);
        dish3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dish3.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(dish3);

        JLabel dish3Price = new JLabel("$2.99");
        dish3Price.setBounds(80, 470, 100, 30);
        dish3Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        mainDish.add(dish3Price);

        JButton increaseButton3 = new JButton("+");
        increaseButton3.setBounds(160, 360, 45, 45);
        increaseButton3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        increaseButton3.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(increaseButton3);

        JButton decreaseButton3 = new JButton("-");
        decreaseButton3.setBounds(160, 400, 45, 45);
        decreaseButton3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        decreaseButton3.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(decreaseButton3);

        menuTab.add("Main Dish", mainDish);

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

        increaseButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter++;
                qtyText.setText(Integer.toString(counter));
            }
        });
    
        decreaseButton1.addActionListener(new ActionListener() {
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

        JLabel getDish2 = new JLabel();
        getDish2.setBounds(5, 40, 200, 20);
        getDish2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(getDish2);
        JLabel getDish2Price = new JLabel();
        getDish2Price.setBounds(270, 40, 100, 20);
        getDish2Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(getDish2Price);
        dish2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                getDish2.setText(dish2.getText());
                getDish2Price.setText(dish2Price.getText());
            }
        });

        JLabel getDish3 = new JLabel();
        getDish3.setBounds(5, 60, 200, 20);
        getDish3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(getDish3);
        JLabel getDish3Price = new JLabel();
        getDish3Price.setBounds(270, 60, 100, 20);
        getDish3Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderList.add(getDish3Price);
        dish3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                getDish3.setText(dish3.getText());
                getDish3Price.setText(dish3Price.getText());
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
