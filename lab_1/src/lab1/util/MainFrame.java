package lab1.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("LAB 1| MENU");
            mainWindow.setLayout(null);
            mainWindow.setSize(250,300);
            mainWindow.setResizable(false);
            mainWindow.getContentPane().setBackground(Color.cyan);
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton task1Button = new JButton("TASK 1");
            task1Button.setSize(150,30);
            task1Button.setLocation(50,70);
            task1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lab1.task1.Window winTask1 = new lab1.task1.Window();
                        winTask1.drawWindow();
                    mainWindow.dispose();
                }
            });

        JButton task2Button = new JButton("TASK 2");
            task2Button.setSize(150,30);
            task2Button.setLocation(50,170);
            task2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lab1.task2.Window winTask2 = new lab1.task2.Window();
                        winTask2.drawWindow();
                    mainWindow.dispose();
                }
            });


        mainWindow.add(task1Button);
        mainWindow.add(task2Button);
        mainWindow.setVisible(true);

    }//End of method
}//End of class
