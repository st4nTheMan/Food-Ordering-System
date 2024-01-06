package system;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

class EWallet {
    private String walletID;
    private double balance;
    private static final String WALLET_FILE_PATH = "wallets.dat";

    public EWallet(String walletID) {
        this.walletID = walletID;
        this.balance = readBalanceFromWalletFile(walletID);
    }

    public void addAmount(double amount) {
        if (amount > 0) {
            balance += amount;
            writeBalanceToWalletFile();
        } else {
            System.out.println("Invalid amount. Amount should be greater than 0.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
        writeBalanceToWalletFile();
    }

    public void deductBalance(double amount) {
        System.out.println("Before Deduction: " + balance);
        balance -= amount;
        System.out.println("After Deduction: " + balance);
        writeBalanceToWalletFile(); // Add this line to update the balance in the file
    }

    private double readBalanceFromWalletFile(String walletID) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(Customer.getFolderPath(), "wallets.dat"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(walletID)) {
                    return Double.parseDouble(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private void writeBalanceToWalletFile() {
        try {
            String walletEntry = walletID + "," + balance + System.lineSeparator();
            Files.write(Paths.get(Customer.getFolderPath(), "wallets.dat"), walletEntry.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerEWallet(String username) {
        // Check if the user already has an E-Wallet
        if (!userHasEWallet(username)) {
            // If not, create a new E-Wallet for the user
            try {
                String walletEntry = username + "," + "0.00";
                Files.write(Paths.get(Customer.getFolderPath(), "wallets.dat"), walletEntry.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "E-Wallet registered successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "You already have an E-Wallet.");
        }
    }

    private static boolean userHasEWallet(String username) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(Customer.getFolderPath(), "wallets.dat"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
