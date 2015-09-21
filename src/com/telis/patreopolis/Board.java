package com.telis.patreopolis;

import javax.swing.*;
import java.awt.*;


public class Board extends JFrame {

    private BoardPanel basic;
    private Tile[] tiles = new Tile[40];

      Board() {

        initializeTiles();
        basic = new BoardPanel(tiles);
        JScrollPane scrollPane = new JScrollPane(basic);
        add(scrollPane);

        //initialize JFrame
        setTitle("El Greco: τα ταξίδια της ζωής και του έργου του");
        setSize(new Dimension(1000, 1020));
        setResizable(false);
        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    // Creating tile objects
    // Types of tiles:
    // 1 = starting point
    // 2 = patras sights
    // 3 = question tiles
    // 4 = train tiles
    // 5 = command tiles
    // 6 = free parking tiles
    // 7 = school tiles
    // 8 = port tiles


    public void initializeTiles() {
        tiles[0] = new Tile("Αφετηρία", "Αφετηρία",0);
        tiles[1] = new Tile("Μουσείο\nΜπενάκη", "Ελλάδα",1);
        tiles[2] = new Tile("Μπόνους\nΕρώτηση", "",2);
        tiles[3] = new Tile("Μουσείο\nΜπενάκη", "",3);
        tiles[4] = new Tile("Ιερά Μητρ/λη\nΣύρου", "",4);
        tiles[5] = new Tile("Υπουργείο\nΠολιτισμού", "",5);
        tiles[6] = new Tile("Εθνική\nΠινακοθήκη", "",6);
        tiles[7] = new Tile("Μπόνους\nΕρώτηση", "",7);
        tiles[8] = new Tile("Ιστορικό\nΜουσείο Κρήτης", "",8);
        tiles[9] = new Tile("Ιστορικό\nΜουσείο Κρήτης", "",9);
        tiles[10] = new Tile("Βιβλίο επίσκεψης Μουσείου", "",10);
        tiles[11] = new Tile("Εθνική πινακοθήκη Μπολώνια", "",11);
        tiles[12] = new Tile("Εθνική πινακοθήκη Πάρμα", "",12);
        tiles[13] = new Tile("Πινακοθήκη Εστένσε", "",13);
        tiles[14] = new Tile("Εθνικό Μουσείο Καποντιμόντε", "",14);
        tiles[15] = new Tile("Υπουργείο Πολιτισμού Ιταλίας", "",15);
        tiles[16] = new Tile("Μουσείο Thyssen- Bornemisza", "",16);
        tiles[17] = new Tile("Μοναστήρι Εσκόριαλ Ισπανίας", "",17);
        tiles[18] = new Tile("SuperBonus Ερώτηση", "",18);
        tiles[19] = new Tile("Μουσείο Πράδο Ισπανίας", "",19);
        tiles[20] = new Tile("Εντευκτήριο", "",20);
        tiles[21] = new Tile("Μουσείο Πράδο Ισπανίας", "",21);
        tiles[22] = new Tile("Μουσείο Πράδο Ισπανίας", "",22);
        tiles[23] = new Tile("Μουσείο Πράδο Ισπανίας", "",23);
        tiles[24] = new Tile("Μουσείο Πράδο Ισπανίας", "",24);
        tiles[25] = new Tile("Μουσείο Πράδο Ισπανίας", "",25);
        tiles[26] = new Tile("Υπουργείο Πολιτισμού Ισπανίας", "",26);
        tiles[27] = new Tile("Καθ/κός Ναός Τολέδο Ισπανίας", "",27);
        tiles[28] = new Tile("Εκκλησία Santo-Tome Τολέδο", "",28);
        tiles[29] = new Tile("Μουσείο Tavera Τολέδο", "",29);
        tiles[30] = new Tile("Πήγαινε στο Βιβλίο Κανονισμών", "",30);
        tiles[31] = new Tile("Ινσ/το ΚαλώνΤεχνών Μινεάπολη", "",31);
        tiles[32] = new Tile("Μητρ/τικό Μουσείο Ν.Υόρκη", "",32);
        tiles[33] = new Tile("Bonus Ερώτηση", "",33);
        tiles[34] = new Tile("Μητρ/τικό Μουσείο Ν.Υόρκη", "",34);
        tiles[35] = new Tile("Υπουργείο Πολιτισμού ΗΠΑ", "",35);
        tiles[36] = new Tile("Μητρ/τικό Μουσείο Ν.Υόρκη", "",36);
        tiles[37] = new Tile("Μητρ/τικό Μουσείο Ν.Υόρκη", "",37);
        tiles[38] = new Tile("Εθνική Πινακοθήκη Ουάσιγκτον", "",38);
        tiles[39] = new Tile("Εθνική Πινακοθήκη Ουάσιγκτον", "",39);
//        tiles[0] = new Tile("starting\npoint", 1);
//        tiles[1] = new Tile("georgiou\nsquare", 2);
//        tiles[2] = new Tile("riga\nferaiou", 2);
//        tiles[3] = new Tile("question", 3);
//        tiles[4] = new Tile("delights\n& tentoura", 2);
//        tiles[5] = new Tile("panachaiki\nstadium", 2);
//        tiles[6] = new Tile("train", 4);
//        tiles[7] = new Tile("Palamas\nhouse", 2);
//        tiles[8] = new Tile("command", 5);
//        tiles[9] = new Tile("Municipal\nTheater ", 2);
//        tiles[10] = new Tile("Free\nParking", 6);
//        tiles[11] = new Tile("Veso\nMare multiplex", 2);
//        tiles[12] = new Tile("question", 3);
//        tiles[13] = new Tile("Psila\nAlonia square", 2);
//        tiles[14] = new Tile("Old\nArsakeio school", 2);
//        tiles[15] = new Tile("train", 4);
//        tiles[16] = new Tile("Dasilio\nregion", 2);
//        tiles[17] = new Tile("command", 5);
//        tiles[18] = new Tile("ancient odeon", 2);
//        tiles[19] = new Tile("school", 7);
//        tiles[20] = new Tile("ancient museum", 2);
//        tiles[21] = new Tile("question", 3);
//        tiles[22] = new Tile("Rio bridge", 2);
//        tiles[23] = new Tile("University", 2);
//        tiles[24] = new Tile("Agiou Nikolaou stairs", 2);
//        tiles[25] = new Tile("train", 4);
//        tiles[26] = new Tile("Pan/siako\nstadium", 2);
//        tiles[27] = new Tile("command", 5);
//        tiles[28] = new Tile("Trion Navarchon street", 2);
//        tiles[29] = new Tile("Port", 8);
//        tiles[30] = new Tile("Achaia Clauss", 2);
//        tiles[31] = new Tile("question", 3);
//        tiles[32] = new Tile("Carnival", 2);
//        tiles[33] = new Tile("Train", 4);
//        tiles[34] = new Tile("Castle", 2);
//        tiles[35] = new Tile("command", 5);
//        tiles[36] = new Tile("Roman bridge", 2);
//        tiles[37] = new Tile("Agios Andreas region", 2);
    }

    public BoardPanel getBoardPanel() {
        return basic;
    }

    public Tile[] getTiles() {
        return tiles;
    }
}
