package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.jar.JarEntry;

class Customer implements ActionListener{
    private JFrame frame;
    private JButton welcomeButton;
    private JButton cashierButton;
    private static JTextArea orderTextArea = new JTextArea();;
    private static int quantity = 0;
    private static JLabel qtyText = new JLabel();

    Customer(JFrame frame){
        this.frame = frame;

        JPanel background = new JPanel(null);
        background.setBounds(0, 0, 1000, 900);
        background.setBackground(Color.decode("#475C7A"));
        frame.add(background);

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setForeground(Color.white);
        Components.addLabel(welcomeLabel, background, "WELCOME!", 340, 40, 450, 100, 60);

        welcomeButton = new JButton("CLICK HERE TO ORDER");
        Components.addButton(welcomeButton, background, 306, 383, 388, 133, 25);
        welcomeButton.addActionListener(this);

        cashierButton = new JButton("FOR CASHIER ONLY!!");
        Components.addButton(cashierButton, background, 400, 750, 200, 40, 14);
        cashierButton.addActionListener(this);

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
        Components.addButton(dish1, mainDish, 40, 40, 115, 115, 12);

        JLabel dish1Price = new JLabel();
        Components.addLabel(dish1Price, mainDish, "P149", 80, 15, 100, 30, 12);

        JButton addToOrderButton1 = new JButton("Add to Order");
        Components.addButton(addToOrderButton1, mainDish, 160, 120, 150, 30, 12);

        JButton increaseButton1 = new JButton("+");
        Components.addButton(increaseButton1, mainDish, 160, 40, 45, 45, 12);

        JButton decreaseButton1 = new JButton("-");
        Components.addButton(decreaseButton1, mainDish, 160, 80, 45, 45, 12);

        JButton dish2 = new JButton("Spags");
        Components.addButton(dish2, mainDish, 40, 200, 115, 115, 12);

        JLabel dish2Price = new JLabel();
        Components.addLabel(dish1Price, mainDish, "P120", 80, 310, 100, 30, 12);

        JButton dish3 = new JButton("Canton");
        Components.addButton(dish3, mainDish, 40, 360, 115, 115, 12);

        JLabel dish3Price = new JLabel();
        Components.addLabel(dish1Price, mainDish, "P32", 80, 470, 100, 30, 12);

        menuTab.add("Main Dish", mainDish);

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

        JButton finishOrderButton = new JButton("Finish Order");
        finishOrderButton.setBounds(664, 710, 150, 30);
        finishOrderButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        finishOrderButton.setBackground(Color.decode("#FFFFFF"));
        orderPagePanel.add(finishOrderButton);
        
        orderTextArea = new JTextArea();
        orderTextArea.setBounds(0, 0, 306, 560);
        orderTextArea.setEditable(false);
        orderList.add(orderTextArea);

        increaseButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quantity++;
                qtyText.setText(Integer.toString(quantity));
            }
        });

        decreaseButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (quantity > 0) {
                    quantity--;
                    qtyText.setText(Integer.toString(quantity));
                }
            }
        });

        addToOrderButton1.addActionListener(new ActionListener() {
            private boolean addedToOrder = false;
        
            public void actionPerformed(ActionEvent event) {
                if (!addedToOrder) {
                    String selectedDish = dish1.getText();
                    String selectedPrice = dish1Price.getText();
                    appendToOrder(selectedDish, selectedPrice);
                    addedToOrder = true;
                }
            }
        });
        
        frame.setVisible(true);
    }

    private static void appendToOrder(String dish, String price) {
        String newText = dish + "\t Price: " + price + "\t Quantity: " + quantity + "\n";
        orderTextArea.append(newText);
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
