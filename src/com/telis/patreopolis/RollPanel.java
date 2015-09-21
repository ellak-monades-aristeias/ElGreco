package com.telis.patreopolis;

import javax.swing.*;
import java.awt.*;


public class RollPanel extends TilePanel {
    String name;
    int money;

    public RollPanel() {
        setLayout(new GridLayout(0,1));
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

//    public String getName() {
//        return name;
//    }

    public void setName(String inName) {
        name = inName;
    }

//    public int getMoney() {
//        return money;
//    }

    public void setMoney(int inMoney) {
        money = inMoney;
    }


}
