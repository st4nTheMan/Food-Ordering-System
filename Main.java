package system;

import javax.swing.*;

class Main{
    public static JFrame frame = new JFrame();
    public static void main(String[] args) {
        frame.setTitle("Food Ordering System");
        frame.setSize(1000, 900);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Customer(frame);
    }
}