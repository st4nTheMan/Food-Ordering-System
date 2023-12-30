package system;

import javax.swing.*;
import java.awt.*;

class Components{
    static void addLabel(JLabel label, JPanel panel, String text, int x, int y,
    int width,int height, int fontSize){
        label.setBounds(x, y, width, height);
        label.setText(text);
        label.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));

        panel.add(label);
    }

    static void addButton(JButton button, JPanel panel, int x, int y,
    int width, int height, int fontSize){
        button.setBounds(x, y, width, height);
        button.setBackground(Color.decode("#FFFFFF"));
        button.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));

        panel.add(button);
    }
}