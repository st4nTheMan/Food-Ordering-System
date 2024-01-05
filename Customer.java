package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.jar.JarEntry;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

class Customer implements ActionListener{
    private static JFrame frame;
    private JButton welcomeButton;
    private JButton cashierButton;
    private static JList<String> orderListJList;
    private static final String FOLDER_PATH = "C:/Users/Jesamine/Desktop/Food Ordering System 3";
    private static final String ORDER_FILE_PATH = FOLDER_PATH + "/orders.dat";

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

        //Main Dish1
        JButton dish1 = new JButton("Fried Chicken");
        Components.addButton(dish1, mainDish, 40, 40, 115, 115, 12);
        
        JLabel dish1Price = new JLabel();
        Components.addLabel(dish1Price, mainDish, "149", 80, 150, 100, 30, 12);

        //Main Dish2
        JButton dish2 = new JButton("Spags");
        Components.addButton(dish2, mainDish, 40, 200, 115, 115, 12);

        JLabel dish2Price = new JLabel();
        Components.addLabel(dish2Price, mainDish, "120", 80, 310, 100, 30, 12);

        //Main Dish3
        JButton dish3 = new JButton("Canton");
        Components.addButton(dish3, mainDish, 40, 360, 115, 115, 12);

        JLabel dish3Price = new JLabel();
        Components.addLabel(dish3Price, mainDish, "32", 80, 470, 100, 30, 12);

        menuTab.add("Main Dish", mainDish);

        JPanel sideDish = new JPanel(null);
        
        //Side Dish 1
        JButton sideDish1 = new JButton("Meatballs");
        Components.addButton(sideDish1,sideDish,40,40,115,115,12);
       
        JLabel sideDish1Price = new JLabel();
        Components.addLabel(sideDish1Price,sideDish,"199",80,150,100,30,12);

        //Side Dish 2
        JButton sideDish2 = new JButton("Itlog");
        Components.addButton(sideDish2,sideDish,40,200,115,115,12);
        sideDish2.setBounds(40, 200, 115, 115);
       
        JLabel sideDish2Price = new JLabel();
        Components.addLabel(sideDish2Price, sideDish, "299", 80, 310, 100, 30, 12);
       
        //Side Dish 3
        JButton sideDish3 = new JButton("Sudan");
        Components.addButton(sideDish3,sideDish,40,360,115,115,12);

        JLabel sideDish3Price = new JLabel();
        Components.addLabel(sideDish3Price,sideDish,"99",80,470,100,30,12);
        
        menuTab.add("Side Dish", sideDish);

        JPanel beverage = new JPanel(null);

        //Beverage 1
        JButton beverage1 = new JButton("C2");
        Components.addButton(beverage1,beverage,40,40,115,115,12);

        JLabel beverage1Price = new JLabel();
        Components.addLabel(beverage1Price,beverage,"30",80,150,100,30,12);
       
        JButton beverage2 = new JButton("Coke");
        Components.addButton(beverage2,beverage,40,200,115,115,12);       

        JLabel beverage2Price = new JLabel();
        Components.addLabel(beverage2Price,beverage,"40",80,310,100,30,12);       

        JButton beverage3 = new JButton("Sudan");
        Components.addButton(beverage3,beverage,40,360,115,115,12);     

        JLabel beverage3Price = new JLabel();
        Components.addLabel(beverage3Price,beverage,"50",80,470,100,30,12);

        menuTab.add("Beverage", beverage);
       
        JPanel dessert = new JPanel(null);

        //Dessert 1
        JButton dess1 = new JButton("Cakes");
        Components.addButton(dess1,dessert,40,40,115,115,12);
       
        JLabel dess1Price = new JLabel();
        Components.addLabel(dess1Price,dessert,"199",80,150,100,30,12);  

        JButton dess2 = new JButton("Coke");
        Components.addButton(dess2,dessert,40,200,115,115,12);
       
        JLabel dess2Price = new JLabel();
        Components.addLabel(dess2Price,dessert,"599",80,310,100,30,12);     

        JButton dess3 = new JButton("Sudan");
        Components.addButton(dess3,dessert,40,360,115,115,12);
    
        JLabel dess3Price = new JLabel();
        Components.addLabel(dess3Price,dessert,"399",80,470,100,30,12);

        menuTab.add("Dessert", dessert);

        JLabel orderListLabel = new JLabel();
        orderListLabel.setForeground(Color.white);
        Components.addLabel(orderListLabel, orderPagePanel, "Orders", 664, 123, 100, 20, 14);

        JPanel orderList = new JPanel(null);
        orderList.setBounds(664, 142, 306, 560);
        orderPagePanel.add(orderList);

        JLabel itemLabel = new JLabel();
        Components.addLabel(itemLabel, orderList, "Item", 5, 0, 100, 20, 12);

        JLabel quantityLabel = new JLabel();
        Components.addLabel(quantityLabel, orderList, "Quantity", 130, 0, 100, 20, 12);

        JLabel priceLabel = new JLabel();
        Components.addLabel(priceLabel, orderList, "Price", 275, 0, 100, 20, 12);

        JButton finishOrderButton = new JButton("Finish Order");
        Components.addButton(finishOrderButton,orderPagePanel,664,710,150,30,14);
        finishOrderButton.setBackground(Color.decode("#FFFFFF"));
     
        DefaultListModel<String> orderListModel = new DefaultListModel<>();
        orderListJList = new JList<>(orderListModel);
        JScrollPane orderListScrollPane = new JScrollPane(orderListJList);
        orderListScrollPane.setBounds(0, 20, 306, 560);
        orderList.add(orderListScrollPane);

        setupDishActionListener(dish1, dish1Price, orderListModel);
        setupDishActionListener(dish2, dish2Price, orderListModel);
        setupDishActionListener(dish3, dish3Price, orderListModel);

        setupDishActionListener(sideDish1, sideDish1Price, orderListModel);
        setupDishActionListener(sideDish2, sideDish2Price, orderListModel);
        setupDishActionListener(sideDish3, sideDish3Price, orderListModel);

        setupDishActionListener(beverage1, beverage1Price, orderListModel);
        setupDishActionListener(beverage2, beverage2Price, orderListModel);
        setupDishActionListener(beverage3, beverage3Price, orderListModel);

        setupDishActionListener(dess1, dess1Price, orderListModel);
        setupDishActionListener(dess2, dess2Price, orderListModel);
        setupDishActionListener(dess3, dess3Price, orderListModel);

        finishOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                generateReceipt(orderListModel);
            }
        });
        
        frame.setVisible(true);
    }

    private static void generateReceipt(DefaultListModel<String> orderListModel) {
        StringBuilder receiptMessage = new StringBuilder("Receipt:\n");

        double totalAmount = 0.0;

        for (int i = 0; i < orderListModel.size(); i++) {
            String orderItem = orderListModel.getElementAt(i);
            receiptMessage.append(orderItem).append("\n");

            String[] itemDetails = orderItem.split("\\s+");
            double itemPrice = Double.parseDouble(itemDetails[itemDetails.length - 1]);
            totalAmount += itemPrice;
        }
        
        receiptMessage.append(String.format("Total Amount: %.2f", totalAmount));

        int option = JOptionPane.showOptionDialog(frame, receiptMessage.toString(),"Order Receipt", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
            new Object[]{"OK"},"OK");
        orderListModel.clear();

        if (option == 0) {
            clearFrame(frame);
            orderPanel(frame);

            createDirectoryIfNotExists(FOLDER_PATH);

            appendOrderToFile(receiptMessage.toString());
        }
    }

    private static void createDirectoryIfNotExists(String folderPath) {
        try {
            Files.createDirectories(Paths.get(folderPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendToOrder(DefaultListModel<String> orderListModel, String dish, String price) {
        String newText = dish + "          " + "1" + "        " + price;
        orderListModel.addElement(newText);
    }

    private static void setupDishActionListener(JButton dishButton, JLabel dishPriceLabel, DefaultListModel<String> orderListModel) {
        dishButton.addActionListener(new ActionListener() {
            private boolean addedToOrder = false;
    
            public void actionPerformed(ActionEvent event) {
                if (!addedToOrder) {
                    String selectedDish = dishButton.getText();
                    String selectedPrice = dishPriceLabel.getText();
                    appendToOrder(orderListModel, selectedDish, selectedPrice);
                    addedToOrder = true;
                }
            }
        });
    }

    private static void appendOrderToFile(String order) {
        try {
            String separator = "\n\n";
            Files.write(
                Paths.get(ORDER_FILE_PATH), 
                (order + separator + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static String getFolderPath() {
        return FOLDER_PATH;
    }

    static void clearFrame(JFrame frame){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.validate();
    }

}
