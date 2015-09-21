package com.telis.patreopolis;

import javax.swing.*;
import java.awt.*;


public class PlayerItem extends JPanel {

    // Initialize icons.
    ImageIcon car1Icon = new ImageIcon(getClass().getResource("car1.png"));
    JLabel car1Label = new JLabel(car1Icon);
    ImageIcon car2Icon = new ImageIcon(getClass().getResource("car2.png"));
    JLabel car2Label = new JLabel(car2Icon);
    ImageIcon car3Icon = new ImageIcon(getClass().getResource("car3.png"));
    JLabel car3Label = new JLabel(car3Icon);
    ImageIcon car4Icon = new ImageIcon(getClass().getResource("car4.png"));
    JLabel car4Label = new JLabel(car4Icon);

    PlayerItem() {

        setBackground(Color.CYAN);
        //width and height of a component
        setPreferredSize(new Dimension(100,75));
		//FlowLayout (int align, int hgap, int vgap)
        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        add(car1Label);
        add(car2Label);
        add(car3Label);
        add(car4Label);
        car1Label.setVisible(false);
        car2Label.setVisible(false);
        car3Label.setVisible(false);
        car4Label.setVisible(false);
    }

    public void revealPlayerItem(int i) {
        if (i == 1)
            car1Label.setVisible(true);
        else if (i == 2)
            car2Label.setVisible(true);
        else if (i == 3)
            car3Label.setVisible(true);
        else if (i == 4)
            car4Label.setVisible(true);
        revalidate();
    }

    public void hidePlayerItem(int i) {
        if (i == 1)
            car1Label.setVisible(false);
        else if (i == 2)
            car2Label.setVisible(false);
        else if (i == 3)
            car3Label.setVisible(false);
        else if (i == 4)
            car4Label.setVisible(false);
        revalidate();
    }

}
