package com.telis.patreopolis;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;


public class TilePanel extends JPanel {

    protected PlayerItem playerItem = new PlayerItem();

    TilePanel() {
        //BoxLayout(Container target, int axis)
        //Y_AXIS - Components are laid out vertically from top to bottom.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        setPreferredSize(new Dimension(100, 120));


        playerItem = new PlayerItem();
    }

    TilePanel(String name, String tileCountry, int position) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        setPreferredSize(new Dimension(90, 90));

        JTextPane namePane = new JTextPane();
        namePane.setPreferredSize(new Dimension(90,50));
        namePane.setMargin(new Insets(0,0,0,0));
        namePane.setEditable(false);
        namePane.setFont(new Font("Arial", Font.BOLD, 10));
        namePane.setText(name);

        StyledDocument doc = namePane.getStyledDocument();
        SimpleAttributeSet centerText = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), centerText, false);

        add(new Bar(tileCountry,position));
        add(namePane);
        if (( position >=1 ) && (position <=9)){    
            playerItem.setBackground(  new Color(23, 113, 197));
        }else if (( position >=11 ) && (position <=14)){    
            playerItem.setBackground(  new Color(115, 168, 119));            
        }else if (( position >=16 ) && (position <=29)){    
            playerItem.setBackground(  new Color(252, 109, 65));            
        }else if (( position >=31 ) && (position <=39)){    
            playerItem.setBackground(  new Color(53, 87, 117));
        }    
        if (position == 0){
            //float[] hsbValues = new float[3];
            playerItem.setBackground(  new Color(48, 97, 210));            
        }else if ((position == 5) || (position == 15) || (position == 26) || (position == 35)){
            playerItem.setBackground(  new Color(172, 72, 147));
        }else if ((position == 7) || (position == 18) ||  (position == 33)){
            playerItem.setBackground(  new Color(83, 172, 72));
        }else if (position == 10){
            playerItem.setBackground(  new Color(250, 120, 57));
        }else if (position == 20){
            playerItem.setBackground(  new Color(93, 57, 250));
        }else if (position == 30){
            playerItem.setBackground(  new Color(250, 57, 71));
        }      
        
        add(playerItem);
//        add(new Bar(Color.white));
        

    }

    public PlayerItem getPlayerItem() {
        return playerItem;
    }

}
