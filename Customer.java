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

        JButton dish2 = new JButton("Spags");
        dish2.setBounds(40, 200, 115, 115);
        dish2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dish2.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(dish2);

        JLabel dish2Price = new JLabel("$2.99");
        dish2Price.setBounds(80, 310, 100, 30);
        dish2Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        mainDish.add(dish2Price);

        JButton dish3 = new JButton("Canton");
        dish3.setBounds(40, 360, 115, 115);
        dish3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dish3.setBackground(Color.decode("#FFFFFF"));
        mainDish.add(dish3);

        JLabel dish3Price = new JLabel("$2.99");
        dish3Price.setBounds(80, 470, 100, 30);
        dish3Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        mainDish.add(dish3Price);

        menuTab.add("Main Dish", mainDish);


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

        JPanel sideDish = new JPanel(null);
        JButton sideDish1 = new JButton("Meatballs");
        sideDish1.setBounds(40, 40, 115, 115);
        sideDish1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        sideDish1.setBackground(Color.decode("#FFFFFF"));
        sideDish.add(sideDish1);

        JLabel sideDishPrice = new JLabel("$1.99");
        sideDishPrice.setBounds(80, 150, 100, 30);
        sideDishPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        sideDish.add(sideDishPrice);

        JButton sideDish2 = new JButton("Itlog");
        sideDish2.setBounds(40, 200, 115, 115);
        sideDish2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        sideDish2.setBackground(Color.decode("#FFFFFF"));
        sideDish.add(sideDish2);

        JLabel dishprice2 = new JLabel("$2.99");
        dishprice2.setBounds(80, 310, 100, 30);
        dishprice2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        sideDish.add(dishprice2); 

        JButton sideDish3 = new JButton("Sudan");
        sideDish3.setBounds(40, 360, 115, 115);
        sideDish3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        sideDish3.setBackground(Color.decode("#FFFFFF"));
        sideDish.add(sideDish3);

        JLabel sideDishprice3 = new JLabel("$2.99");
        sideDishprice3.setBounds(80, 470, 100, 30);
        sideDishprice3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        sideDish.add(sideDishprice3);

        menuTab.add("Side Dish", sideDish);

        JButton increaseButton2 = new JButton("+");
        increaseButton2.setBounds(160, 40, 45, 45);
        increaseButton2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        increaseButton2.setBackground(Color.decode("#FFFFFF"));
        sideDish.add(increaseButton2);

        JButton decreaseButton2 = new JButton("-");
        decreaseButton2.setBounds(160, 80, 45, 45);
        decreaseButton2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        decreaseButton2.setBackground(Color.decode("#FFFFFF"));
        sideDish.add(decreaseButton2);
        





        JPanel beverage = new JPanel(null);
        JButton bev1 = new JButton("C2");
        bev1.setBounds(40, 40, 115, 115);
        bev1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        bev1.setBackground(Color.decode("#FFFFFF"));
        beverage.add(bev1);

        JLabel bev1Price = new JLabel("$1.99");
        bev1Price.setBounds(80, 150, 100, 30);
        bev1Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        beverage.add(bev1Price);

        JButton bev2 = new JButton("Coke");
        bev2.setBounds(40, 200, 115, 115);
        bev2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        bev2.setBackground(Color.decode("#FFFFFF"));
        beverage.add(bev2);

        JLabel bev2Price = new JLabel("$2.99");
        bev2Price.setBounds(80, 310, 100, 30);
        bev2Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        beverage.add(bev2Price); 

        JButton bev3 = new JButton("Sudan");
        bev3.setBounds(40, 360, 115, 115);
        bev3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        bev3.setBackground(Color.decode("#FFFFFF"));
        beverage.add(bev3);

        JLabel bev3Price = new JLabel("$2.99");
        bev3Price.setBounds(80, 470, 100, 30);
        bev3Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        beverage.add(bev3Price);

        menuTab.add("Beverage", beverage);

        JButton increaseButton3 = new JButton("+");
        increaseButton3.setBounds(160, 40, 45, 45);
        increaseButton3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        increaseButton3.setBackground(Color.decode("#FFFFFF"));
        beverage.add(increaseButton3);

        JButton decreaseButton3 = new JButton("-");
        decreaseButton3.setBounds(160, 80, 45, 45);
        decreaseButton3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        decreaseButton3.setBackground(Color.decode("#FFFFFF"));
        beverage.add(decreaseButton3);


        JPanel dessert = new JPanel(null);
        JButton dess1 = new JButton("Cakes");
        dess1.setBounds(40, 40, 115, 115);
        dess1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dess1.setBackground(Color.decode("#FFFFFF"));
        dessert.add(dess1);

        JLabel dessPrice1 = new JLabel("$1.99");
        dessPrice1.setBounds(80, 150, 100, 30);
        dessPrice1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dessert.add(dessPrice1);

        JButton dess2 = new JButton("Coke");
        dess2.setBounds(40, 200, 115, 115);
        dess2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dess2.setBackground(Color.decode("#FFFFFF"));
        dessert.add(dess2);

        JLabel dessPrice2 = new JLabel("$2.99");
        dessPrice2.setBounds(80, 310, 100, 30);
        dessPrice2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dessert.add(dessPrice2); 

        JButton dess3 = new JButton("Sudan");
        dess3.setBounds(40, 360, 115, 115);
        dess3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dess3.setBackground(Color.decode("#FFFFFF"));
        dessert.add(dess3);

        JLabel dessPrice3 = new JLabel("$2.99");
        dessPrice3.setBounds(80, 470, 100, 30);
        dessPrice3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dessert.add(dessPrice3);

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
