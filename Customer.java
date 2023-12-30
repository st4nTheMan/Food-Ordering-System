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
        Components.addButton(sideDish1,sideDish,40,40,115,115,12);
       
        JLabel sideDishPrice = new JLabel();
        Components.addLabel(sideDishPrice,sideDish,"$1.99",80,150,100,30,12);
        

        JButton increaseButton2 = new JButton("+");
        Components.addButton(increaseButton2,sideDish,160,40,45,45,12);
        
        JButton decreaseButton2 = new JButton("-");
        Components.addButton(decreaseButton2,sideDish,160,80,45,45,12);
        

        JButton sideDish2 = new JButton("Itlog");
        Components.addButton(sideDish2,sideDish,40,200,115,115,12);
        sideDish2.setBounds(40, 200, 115, 115);

       
        JLabel dishprice2 = new JLabel();
        Components.addLabel(dishprice2,sideDish,"$2.99",80,310,100,30,12);
       

        JButton sideDish3 = new JButton("Sudan");
        Components.addButton(sideDish3,sideDish,40,360,115,115,12);

       

        JLabel sideDishprice3 = new JLabel();
        Components.addLabel(sideDishprice3,sideDish,"$2.99",80,470,100,30,12);
        
        menuTab.add("Side Dish", sideDish);
        

        JPanel beverage = new JPanel(null);

        JButton bev1 = new JButton("C2");
        Components.addButton(bev1,beverage,40,40,115,115,12);
       

        JLabel bev1Price = new JLabel();
        Components.addLabel(bev1Price,beverage,"$1.99",80,150,100,30,12);

       

        JButton bev2 = new JButton("Coke");
        Components.addButton(bev2,beverage,40,200,115,115,12);
       

        JLabel bev2Price = new JLabel();
        Components.addLabel(bev2Price,beverage,"$2.99",80,310,100,30,12);
        

        JButton bev3 = new JButton("Sudan");
        Components.addButton(bev3,beverage,40,360,115,115,12);
     

        JLabel bev3Price = new JLabel();
        Components.addLabel(bev3Price,beverage,"$2.99",80,470,100,30,12);

        menuTab.add("Beverage", beverage);

        JButton increaseButton3 = new JButton("+");
        Components.addButton(increaseButton3,beverage,160,40,45,45,12);

       

        JButton decreaseButton3 = new JButton("-");
        Components.addButton(decreaseButton3,beverage,160,80,45,45,12);
       
        JPanel dessert = new JPanel(null);
        JButton dess1 = new JButton("Cakes");
        Components.addButton(dess1,dessert,40,40,115,115,12);
       
        JLabel dessPrice1 = new JLabel();
        Components.addLabel(dessPrice1,dessert,"$1.99",80,150,100,30,12);

       

        JButton dess2 = new JButton("Coke");
        Components.addButton(dess2,dessert,40,200,115,115,12);
       

        JLabel dessPrice2 = new JLabel();
        Components.addLabel(dessPrice2,dessert,"$2.99",80,310,100,30,12);

       

        JButton dess3 = new JButton("Sudan");
        Components.addButton(dess3,dessert,40,360,115,115,12);

    
        JLabel dessPrice3 = new JLabel();
        Components.addLabel(dessPrice3,dessert,"$2.99",80,470,100,30,12);

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
        Components.addButton(finishOrderButton,orderPagePanel,664,710,150,30,14);
        finishOrderButton.setBackground(Color.decode("#FFFFFF"));
     
        
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
