package lab1.task2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Diagram extends JPanel{

    int numberOfCols;
    int [] heightCol;
    int widthCol, widthSpace, heightSpace;

    Diagram(int numberCols, int widthSpace, int heightSpace){
        this.numberOfCols = numberCols;
        this.widthSpace = widthSpace;
        this.heightSpace = heightSpace;


        Random rand = new Random();

        widthCol = widthSpace/numberCols;
        heightCol = new int[numberCols];
        for (int i = 0; i < numberCols; i++) {
            heightCol[i] = rand.nextInt(heightSpace);
        }
    }//End of Constructor

    @Override
    public void paint(Graphics g){
        for(int i = 0, xCoord = 0;i < numberOfCols; i++, xCoord +=(widthCol+1) ){
            g.fillRect(xCoord,heightSpace-heightCol[i],widthCol,heightCol[i]);
        }
    }//End of method

    void sortRectungleByheight(){
        int bufer;
        int i;

        for(int j = 1; j < numberOfCols; j++) {
            for (i = 0; i < numberOfCols - j; i++) {
                if (heightCol[i] > heightCol[i + 1]) {
                    bufer = heightCol[i];
                    heightCol[i] = heightCol[i + 1];
                    heightCol[i + 1] = bufer;
                }
            }
        }
    }//End of method

}//End of class
