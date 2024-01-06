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
    private JButton registerWalletButton;
    private JButton viewWalletButton;
    private JButton addAmountButton;
    private static JList<String> orderListJList;
    private static final String FOLDER_PATH = "";
    private static final String ORDER_FILE_PATH = FOLDER_PATH + "/orders.dat";
    private static final String WALLET_FILE_PATH = FOLDER_PATH + "/wallets.dat";

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

        registerWalletButton = new JButton("Register E-Wallet");
        Components.addButton(registerWalletButton, background, 664, 650, 200, 40, 14);
        registerWalletButton.addActionListener(this);

        viewWalletButton = new JButton("View E-Wallet");
        Components.addButton(viewWalletButton, background, 664, 700, 200, 40, 14);
        viewWalletButton.addActionListener(this);

        addAmountButton = new JButton("Add Amount");
        Components.addButton(addAmountButton, background, 664, 750, 200, 40, 14);
        addAmountButton.addActionListener(this);

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
        Components.addLabel(dish1Price, mainDish, "149", 85, 150, 100, 30, 12);

        //Main Dish2
        JButton dish2 = new JButton("Spags");
        Components.addButton(dish2, mainDish, 40, 200, 115, 115, 12);

        JLabel dish2Price = new JLabel();
        Components.addLabel(dish2Price, mainDish, "120", 85, 310, 100, 30, 12);

        //Main Dish3
        JButton dish3 = new JButton("Canton");
        Components.addButton(dish3, mainDish, 40, 360, 115, 115, 12);

        JLabel dish3Price = new JLabel();
        Components.addLabel(dish3Price, mainDish, "32", 87, 470, 100, 30, 12);

        menuTab.add("Main Dish", mainDish);

        JPanel sideDish = new JPanel(null);
        
        //Side Dish 1
        JButton sideDish1 = new JButton("Meatballs");
        Components.addButton(sideDish1, sideDish, 40, 40, 115, 115, 12);
       
        JLabel sideDish1Price = new JLabel();
        Components.addLabel(sideDish1Price, sideDish, "199", 80, 150, 100, 30, 12);

        //Side Dish 2
        JButton sideDish2 = new JButton("Itlog");
        Components.addButton(sideDish2, sideDish, 40, 200, 115, 115, 12);
       
        JLabel sideDish2Price = new JLabel();
        Components.addLabel(sideDish2Price, sideDish, "299", 80, 310, 100, 30, 12);
       
        //Side Dish 3
        JButton sideDish3 = new JButton("Sudan");
        Components.addButton(sideDish3, sideDish, 40, 360, 115, 115, 12);

        JLabel sideDish3Price = new JLabel();
        Components.addLabel(sideDish3Price, sideDish, "99", 80, 470, 100, 30, 12);
        
        menuTab.add("Side Dish", sideDish);

        JPanel beverages = new JPanel(null);

        //Beverage 1
        JButton beverage1 = new JButton("C2");
        Components.addButton(beverage1, beverages, 40, 40, 115, 115, 12);

        JLabel beverage1Price = new JLabel();
        Components.addLabel(beverage1Price, beverages, "30" ,80, 150, 100, 30, 12);
       
        JButton beverage2 = new JButton("Coke");
        Components.addButton(beverage2,beverages, 40, 200, 115, 115, 12);       

        JLabel beverage2Price = new JLabel();
        Components.addLabel(beverage2Price, beverages, "40", 80, 310, 100, 30, 12);       

        JButton beverage3 = new JButton("Sudan");
        Components.addButton(beverage3, beverages, 40, 360, 115, 115, 12);     

        JLabel beverage3Price = new JLabel();
        Components.addLabel(beverage3Price, beverages, "50", 80, 470, 100, 30, 12);

        menuTab.add("Beverage", beverages);
       
        JPanel desserts = new JPanel(null);

        //Dessert 1
        JButton dess1 = new JButton("Cakes");
        Components.addButton(dess1, desserts, 40, 40, 115, 115, 12);
       
        JLabel dess1Price = new JLabel();
        Components.addLabel(dess1Price, desserts, "199", 80, 150, 100, 30, 12);  

        JButton dess2 = new JButton("Coke");
        Components.addButton(dess2, desserts, 40, 200, 115, 115, 12);
       
        JLabel dess2Price = new JLabel();
        Components.addLabel(dess2Price, desserts, "599", 80, 310, 100, 30, 12);     

        JButton dess3 = new JButton("Sudan");
        Components.addButton(dess3, desserts, 40, 360, 115, 115, 12);
    
        JLabel dess3Price = new JLabel();
        Components.addLabel(dess3Price, desserts, "399", 80, 470, 100, 30, 12);

        menuTab.add("Dessert", desserts);

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

        JButton clearOrdersButton = new JButton("Clear Orders");
        Components.addButton(clearOrdersButton, orderPagePanel, 830, 710, 150, 30, 14);
        clearOrdersButton.setBackground(Color.decode("#FFFFFF"));

        clearOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear all orders?", "Clear Orders", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    orderListModel.clear();
                }
            }
        });

        JButton backButton = new JButton("Back to Homepage");
        Components.addButton(backButton, orderPagePanel, 30, 20, 150, 30, 14);
        backButton.setBackground(Color.decode("#FFFFFF"));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFrame(frame);
                new Customer(frame);
            }
        });
        
        frame.setVisible(true);
    }

    public static String getWalletFilePath() {
        return WALLET_FILE_PATH;
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
    
        // Choose between Dine in, Take out, or E-Wallet payment
        String[] paymentOptions = {"Dine in", "Take out", "E-Wallet", "Cancel"};
        int option = JOptionPane.showOptionDialog(frame, receiptMessage.toString(), "Order Receipt",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, paymentOptions, "Cancel");
    
        orderListModel.clear();
    
        if (option == 0 || option == 1) { // Dine in or Take out
            String orderType = (option == 0) ? "Dine in" : "Take out";
            clearFrame(frame);
            orderPanel(frame);
            
            createDirectoryIfNotExists(FOLDER_PATH);
            appendOrderToFile(receiptMessage.toString(), orderType);
        } else if (option == 2) { // E-Wallet
            handleEWalletPayment(orderListModel);
        }
    }

    private static void createDirectoryIfNotExists(String folderPath) {
        try {
            Files.createDirectories(Paths.get(folderPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendToOrder(DefaultListModel<String> orderListModel, String dish, String price, int quantity) {
        String newText = dish + "          " + quantity + "        " + price;
        orderListModel.addElement(newText);
    }

    private static void setupDishActionListener(JButton dishButton, JLabel dishPriceLabel, DefaultListModel<String> orderListModel) {
        dishButton.addActionListener(new ActionListener() {
            private boolean addedToOrder = false;
    
            public void actionPerformed(ActionEvent event) {
                SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
                JSpinner quantitySpinner = new JSpinner(spinnerModel);
    
                int result = JOptionPane.showOptionDialog(frame, quantitySpinner, "Select Quantity",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    
                if (result == JOptionPane.OK_OPTION) {
                    int quantity = (int) quantitySpinner.getValue();
                    String selectedDish = dishButton.getText();
                    double originalPrice = Double.parseDouble(dishPriceLabel.getText());
                    double newPrice = originalPrice * quantity;
    
                    String formattedNewPrice = String.format("%.2f", newPrice);
    
                    appendToOrder(orderListModel, selectedDish, formattedNewPrice, quantity);
                    addedToOrder = true;
                } else {
                    addedToOrder = false;
                }
            }
        });
    }

    private static void appendOrderToFile(String order, String orderType) {
        try {
            String separator = "\n";
            Files.write(
                Paths.get(ORDER_FILE_PATH), 
                (order + separator + orderType + separator + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleEWalletPayment(DefaultListModel<String> orderListModel) {
        String username = JOptionPane.showInputDialog(frame, "Enter your username:");
        if (username != null && !username.isEmpty()) {
            EWallet eWallet = new EWallet(username);
            double totalAmount = calculateTotalAmount(orderListModel);
    
            int paymentOption = JOptionPane.showOptionDialog(frame,
                    "Total Amount: P" + String.format("%.2f", totalAmount) + "\nChoose an option:",
                    "Payment Options", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Pay with E-Wallet"}, "Cancel");
    
            if (paymentOption == 0) {
                if (eWallet.getBalance() >= totalAmount) {
                    eWallet.deductBalance(totalAmount);
                    JOptionPane.showMessageDialog(frame, "Payment successful using E-Wallet!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance in E-Wallet. Please add more money.");
                }
                // Clear the order list model after completing the payment
                orderListModel.clear();
            }
        }
    }

    private static double calculateTotalAmount(DefaultListModel<String> orderListModel) {
        double totalAmount = 0.0;
    
        for (int i = 0; i < orderListModel.size(); i++) {
            String orderItem = orderListModel.getElementAt(i);
            String[] itemDetails = orderItem.split("\\s+");
            double itemPrice = Double.parseDouble(itemDetails[itemDetails.length - 1]);
            totalAmount += itemPrice;
        }
    
        return totalAmount;
    }

    private void handleAddAmount() {
        String username = JOptionPane.showInputDialog(frame, "Enter your username:");
        if (username != null && !username.isEmpty()) {
            EWallet eWallet = new EWallet(username);
            double currentBalance = eWallet.getBalance();

            // Prompt the user for the amount to add
            String amountStr = JOptionPane.showInputDialog(frame, "Enter the amount to add:");
            try {
                double amount = Double.parseDouble(amountStr);
                eWallet.addAmount(amount);
                JOptionPane.showMessageDialog(frame, "Amount added successfully. New balance: P" + String.format("%.2f", eWallet.getBalance()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.");
            }
        }
    }

    private void handleRegisterWallet() {
        String username = JOptionPane.showInputDialog(frame, "Enter your username:");
        if (username != null && !username.isEmpty()) {
            EWallet.registerEWallet(username);
            JOptionPane.showMessageDialog(frame, "E-Wallet registered successfully!");
        }
    }

    private void handleViewWallet() {
        String username = JOptionPane.showInputDialog(frame, "Enter your username:");
        if (username != null && !username.isEmpty()) {
            EWallet eWallet = new EWallet(username);
            double balance = eWallet.getBalance();
            JOptionPane.showMessageDialog(frame, "Your E-Wallet balance: P" + String.format("%.2f", balance));
        }
    }

    public static String getFolderPath() {
        return FOLDER_PATH;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == welcomeButton) {
            clearFrame(frame);
            orderPanel(frame);
        } else if (event.getSource() == cashierButton) {
            clearFrame(frame);
            new Cashier(frame);
        } else if (event.getSource() == registerWalletButton) {
            handleRegisterWallet();
        } else if (event.getSource() == viewWalletButton) {
            handleViewWallet();
        } else if (event.getSource() == addAmountButton) {
            handleAddAmount();
        }
    }

    static void clearFrame(JFrame frame){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.validate();
    }

}
