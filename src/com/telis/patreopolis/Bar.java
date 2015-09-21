package com.telis.patreopolis;

import javax.swing.*;
import java.awt.*;


public class Bar extends JPanel {

//    private Color barColor;
    private String barString;
    private int barPosition;

    public void paint (Graphics g)
    {
        super.paintComponent(g);
        setBorder(BorderFactory.createLineBorder(Color.white, 0));
//        g.drawRect(0, 0, 100, 130);
//      drawRect(int x, int y, int width, int height)
        g.drawRect(0, 0, 100, 20);
//        g.setColor(barColor);
        g.setColor(Color.white);
        g.drawString(barString, 100, 20);
//        g.fillRect(0, 0, 100, 130);        
        g.fillRect(0, 0, 100, 20);
    }
    Bar (String country, int position) {
        barString = country;
        barPosition = position;
    }
//    Bar (Color color) {barColor = color;}

}
