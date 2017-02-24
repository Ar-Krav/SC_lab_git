package lab1.task1;


import lab1.util.InputDialog;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    public void drawWindow(){
        JFrame window = new JFrame("lab_1");
            window.setLayout(null);
            window.setSize(900,536);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The util panel for moving of the cube
        JPanel panel = new JPanel(new BorderLayout());
            panel.setSize(550,400);
            panel.setLocation(30,60);
            Border lineBorder = BorderFactory.createLineBorder(Color.BLUE);
            panel.setBorder(lineBorder);
            panel.setOpaque(true);
            panel.setBackground(Color.RED);


        //Preparing the coordinates for the rectungle.
        Point startPosition = new Point();
            startPosition.setLocation(0,0);
        Point coordEndOfField = new Point();
            coordEndOfField.setLocation(panel.getWidth(),panel.getHeight());


        //Info labels
        JLabel viewportLabel = new JLabel("VIEWPORT:");
            viewportLabel.setFont( new Font("Verdana", Font.PLAIN, 20));
            viewportLabel.setSize(viewportLabel.getPreferredSize());
            viewportLabel.setLocation(90, 25);

        JLabel settingLabel = new JLabel("SETTING:");
            settingLabel.setFont( new Font("Verdana", Font.PLAIN, 20));
            settingLabel.setSize(settingLabel.getPreferredSize());
            settingLabel.setLocation(645, 25);

        JLabel inputXLabel = new JLabel("<html>Please, input X coordinate:<br><br>Now X is  </html>");
            inputXLabel.setFont( new Font("Verdana", Font.PLAIN, 16));
            inputXLabel.setSize(inputXLabel.getPreferredSize());
            inputXLabel.setLocation(620, 100);

        JLabel inputYLabel = new JLabel("<html>Please, input Y coordinate:<br><br>Now Y is  </html>");
            inputYLabel.setFont( new Font("Verdana", Font.PLAIN, 16));
            inputYLabel.setSize(inputYLabel.getPreferredSize());
            inputYLabel.setLocation(620, 250);


        //Creation of Buttons
        JButton inputXButton = new JButton("" + (int)startPosition.getX());
            inputXButton.setSize(130,30);
            inputXButton.setFont( new Font("Verdana", Font.PLAIN, 16));
            inputXButton.setLocation(710,138);
            inputXButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InputDialog xCoordDialog = new InputDialog();
                    startPosition.setLocation(xCoordDialog.showInputDialog(), startPosition.getY());
                    inputXButton.setText("" + startPosition.getX());
                }
            });

        JButton inputYButton = new JButton("" + (int)startPosition.getY());
            inputYButton.setSize(130,30);
            inputYButton.setFont( new Font("Verdana", Font.PLAIN, 16));
            inputYButton.setLocation(710,288);
            inputYButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InputDialog yCoordDialog = new InputDialog();
                    startPosition.setLocation(startPosition.getX(), yCoordDialog.showInputDialog());
                    inputYButton.setText("" + startPosition.getY());
                }
            });

        JButton startButton = new JButton("START");
            startButton.setSize(220,40);
            startButton.setFont( new Font("Verdana", Font.PLAIN, 24));
            startButton.setLocation(620,385);
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Rectungle cube = new Rectungle(startPosition,coordEndOfField, panel);
                    panel.add(cube);
                    cube.moveRectangle();
                    window.repaint();
                    window.validate();
                }
            });


        //add component to the Window
        window.add(panel);

        window.add(viewportLabel);
        window.add(settingLabel);
        window.add(inputXLabel);
        window.add(inputYLabel);

        window.add(inputXButton);
        window.add(inputYButton);
        window.add(startButton);

        window.setVisible(true);
    }//End of method

}//End of class
