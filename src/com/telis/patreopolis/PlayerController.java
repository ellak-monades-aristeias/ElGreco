package com.telis.patreopolis;


import com.telis.patreopolissoap2.PatreopolisSOAP2Copy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;


public class PlayerController extends JFrame {
    
    
    private PatreopolisSOAP2Copy patreopolisSOAPProxy;
    final int PLAYER_COUNT = 4;
//    List<Question> myQuestions;
//    Question model = new Question();
    Question[] model = new Question[2];
    PlayerModel playerModelArray[] = new PlayerModel[PLAYER_COUNT];
    //    ArrayList<player> playerArrayList = new ArrayList<player>(numOfPlayers);
    Board board;
    String message1 = "";
    String message2 = "";
    String res;
    Die dieObject = new Die();
    int dieTemp;
    int inputvalue;
    int round = 0;
//    boolean superBonusFlag = true;
    ButtonGroup buttonGroup;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
 // JButton rollButton2;
//  JTextField textfield;
//    int answer;
    boolean endOfGame = false;
    boolean message = true;
    boolean turnEnd = false;
    RollPanel rollPanel = new RollPanel();
    JDialog rollWindow = new JDialog();
    

    // Start a new game with numOfPlayers players.
     public PlayerController(Question[] model) {
//        this.myQuestions = new ArrayList<Question>();
//         pack();
//        setLocation(1000,1000); 
//        setLocationRelativeTo(rollWindow);
//        setAlwaysOnTop(true);
//        setVisible(true);
        this.model = model;
         
//         this.myQuestions = myQuestions;
        board = new Board();

        for (int i = 0; i < PLAYER_COUNT; i++) {

            playerModelArray[i] = new PlayerModel(i+1);
        }
        
       
        
        try {
                
            com.telis.patreopolissoap2.PatreopolisSOAP2CopyService service = new com.telis.patreopolissoap2.PatreopolisSOAP2CopyService();
            patreopolisSOAPProxy = service.getPatreopolisSOAP2CopyPort();
        }
        catch (Exception exception){
        exception.printStackTrace();
        System.exit(1);
        }
    }

    public void run() throws IOException, URISyntaxException {
//        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(1);
//        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(2);
//        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(3);
//        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(4);
        JOptionPane optionPane = new JOptionPane("Πόσοι παίκτες θες να παίξουν σε αυτό το παιχνίδι;"
                                                 + " 2, 3 ή 4;"
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , null, null, null);
        optionPane.setWantsInput(true);             
        JDialog dialog = optionPane.createDialog(null, "Αριθμός παικτών");
        dialog.setLocation(500, 80);
        dialog.setVisible(true);
        String inputvalueTemp = (String)optionPane.getInputValue();
        inputvalue = Integer.parseInt(inputvalueTemp);
        System.out.println(inputvalue);
        if(inputvalue == 2){
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(1);
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(2);
//        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(3);
//        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(4);
        }
        else if (inputvalue == 3){
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(1);
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(2);
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(3);
//        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(4);    
        }
        else if (inputvalue == 4){
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(1);
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(2);
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(3);
        board.getTiles()[0].getTilePanel().getPlayerItem().revealPlayerItem(4);
        }
        
        
//        createRollPanel(playerModelArray[0]);
        
       
        do {
            
            try {
                createRollPanel("Ρίξε το ζάρι", "Κλικάροντας το κουμπί");
                Thread.currentThread();
                Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
            }
        while (turnEnd == false);

//        while (endOfGame == false) {
         while (isGameOver() == false) 
         {
            for (int i = 0; i < inputvalue; i++) {
                turnEnd = false;
                // Roll die. process turn information;
                // move player. pause until 'end turn' button is pressed.
                dieTemp = dieObject.roll();
//                dieTemp = patreopolisSOAPProxy.roll();
//                turn(playerModelArray[i]);
//                final Random rand = new Random();
//                Question model = new Question(rand.nextInt(18) + 1);
//                 Question model = new Question(i);
//                model[i] = new Question(i);
                move(playerModelArray[i]);
                //an i thesi einai 10 tote parameneis ekei mexri ton epomeno giro
//                if(playerModelArray[i].getLocation() == 10){}
                if(playerModelArray[i].getMoney() <= 0){
//                 createRollPanel(playerModelArray[k], "Συγχαρητήρια", "Νίκησες");
                JOptionPane optionPane2 = new JOptionPane("Παίκτη " + Integer.toString(playerModelArray[i].getPlayerId()) 
                                                         + " νίκησες!"
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , null, null, null);
        optionPane2.setWantsInput(false);             
        JDialog dialog2 = optionPane2.createDialog(null, "Τέλος παιχνιδιού");
        dialog2.setLocation(500, 80);
        dialog2.setVisible(true);
                }
                createRollPanel(playerModelArray[i]);
                while (turnEnd == false) {
                    try {Thread.currentThread();
                        Thread.sleep(1000);}
                    catch (InterruptedException e) {}
                }
            }
        }

    }
    

    public boolean isGameOver(){
    
        for (int k = 0; k < inputvalue; k++) {
            if(playerModelArray[k].getMoney() <= 0)
                return true;
        }
         return false;
    }

    public void move(PlayerModel playerModelUnit) throws URISyntaxException {
        // Hide old player Unit
        int location = playerModelUnit.getLocation();
        board.getTiles()[location].getTilePanel().getPlayerItem().hidePlayerItem(playerModelUnit.getPlayerId());

        round = (location + dieTemp) /39;
        playerModelUnit.setRound(round);
        int oldLocation = location;
        // Get to the new location
        location = (location + dieTemp) % 39;

        // Catch cases (38)

        // If you get at Starting Point (0), get an amount of money (e.g. 200 Euros)
        if (oldLocation >= 34 && location <= 5) {
            message1 = "Πέρασες την αφετηρία ή είσαι πάνω σε αυτή!";
            message2 = "Σου προστίθενται 20 δουκάτα";
//            location = 1;
            playerModelUnit.money = playerModelUnit.money + 20;
////            playerModelUnit.addMoney(200);
        }
       //monuments(1, 2, 4, 5, 7, 9, 11, 13, 14, 16, 18, 20, 22, 23, 24, 26, 28, 30, 32, 34, 36, 37)
        else if (location == 1 )
//                || location == 2  || location == 4  || location == 5  || location == 7  ||
//                 location == 9  || location == 11 || location == 13 || location == 14 || location == 16 ||
//                 location == 18 || location == 20 || location == 22 || location == 23 || location == 24 ||
//                 location == 26 || location == 28 || location == 30 || location == 32 || location == 34 ||
//                 location == 36 || location == 37)
            
        {
//            String answer = createAndDisplayGUI("2.png", 19);
            String answer = createAndDisplayGUI(19);
//            String answer = createAndDisplayGUI("3.png");
//            String answer = createAndDisplayGUI(0);
            if (answer.equalsIgnoreCase("1"))
            {
            
            playerModelUnit.deductMoney(5);
            message1 = "Πληρώνεις 5 δουκάτα για την επίσκεψη";
            Icon icon = new ImageIcon(getClass().getResource("2.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
        optionPane.setWantsInput(false);             
        JDialog dialog = optionPane.createDialog(null, "Ευαγγελιστής Λουκάς");
        dialog.setLocation(200, 80);
        dialog.setVisible(true);
//             String res2 = createAndDisplayGUI();
            }
            else 
            {
                playerModelUnit.deductMoney(5);
                message1 = " Πληρώνεις 5 δουκάτα για τη λάθος απάντηση ";
            }
        }
        else if (location == 2 )
        {
            message1 = "Απάντησε τη bonus ερώτηση";
            final Random rand = new Random();
            String res = createAndDisplayGUI(rand.nextInt(19)+1);
            if (res.equals(model[rand.nextInt(19)].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Σου προστίθενται 15 δουκάτα!";
                playerModelUnit.addMoney(15);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Μένεις στην ίδια θέση!";
            }
        
        
        }
        
        else if (location == 3 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("3.png", 20);
            String res = createAndDisplayGUI(20);
            if (res.equals(model[20].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Σου αφαιρούνται 5 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(5);
            Icon icon = new ImageIcon(getClass().getResource("3.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η προσκύνηση των μάγων");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος. Πληρώνεις 5 δουκάτα";
                message2 = "Μένεις στην ίδια θέση!";
            }
        
        
        }
        
        else if (location == 4 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("4.png", 21);
            String res = createAndDisplayGUI(21);
            if (res.equals(model[21].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 7 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(7);
                
                Icon icon = new ImageIcon(getClass().getResource("4.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η κοίμηση της Θεοτόκου");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                
            }
        
        
        }
        
        else if (location == 5 )
        {
            message1 = "Θα δεχτείς οικονομική ενίσχυση 25 δουκάτων για να συνεχίσεις";
            message2 = "το ταξίδι σου στο κόσμο των δημιουργιών του El Greco.";
            playerModelUnit.addMoney(25);
        }
        
        else if (location == 6 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("5.png", 22);
            String res = createAndDisplayGUI(22);
            if (res.equals(model[22].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 8 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(8);
                
                Icon icon = new ImageIcon(getClass().getResource("5.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Στέψη της Θεοτόκου");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        
        
        }
        
        else if (location == 7 )
        {
             message1 = "Απάντησε τη bonus ερώτηση";
            final Random rand = new Random();
            int i = rand.nextInt(19)+1;
            String res = createAndDisplayGUI(i-1);
            if (res.equals(model[i-1].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Σου προστίθενται 15 δουκάτα!";
                playerModelUnit.addMoney(15);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Μένεις στην ίδια θέση!";
            }
        }
        
        else if (location == 8 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("6.png", 23);
            String res = createAndDisplayGUI(23);
            if (res.equals(model[23].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 10 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(10);
                
                Icon icon = new ImageIcon(getClass().getResource("6.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, " Άποψη Όρους Σινά");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        
        else if (location == 9 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("7.png", 24);
            String res = createAndDisplayGUI(24);
            if (res.equals(model[24].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 10 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(10);
                
                Icon icon = new ImageIcon(getClass().getResource("7.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η βάπτιση του Χριστού");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 10 )
        {
            message1 = "Βιβλίο Κανονισμού επίσκεψης μουσείου.";
            message2 = "Παραμένεις στη θέση αυτή μέχρι τον επόμενο γύρο."; 
            playerModelUnit.setRound(round-1);
        }
        
        else if (location == 11 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("8.png", 25);
            String res = createAndDisplayGUI(25);
            if (res.equals(model[25].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 12 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(12);
                
                Icon icon = new ImageIcon(getClass().getResource("8.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Ο μυστικός Δείπνος");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 12 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("9.png", 26);
            String res = createAndDisplayGUI(26);
            if (res.equals(model[26].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 13 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(13);
                
                Icon icon = new ImageIcon(getClass().getResource("9.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η θεραπεία του τυφλού");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 13 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("10.png", 27);
            String res = createAndDisplayGUI(27);
            if (res.equals(model[27].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 14 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(14);
                
                Icon icon = new ImageIcon(getClass().getResource("10.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Το τρίπτυχο της Μοδένας");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 14 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("11.png", 28);
            String res = createAndDisplayGUI(28);
            if (res.equals(model[28].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 15 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(15);
                
                Icon icon = new ImageIcon(getClass().getResource("12.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Προσωπογραφία του Τζούλιο Κλόβιο");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
         else if (location == 15 )
        {
            message1 = "Δέχεσαι οικονομική ενίσχυση 25 δουκάτων για να συνεχίσεις";
            message2 = "το ταξίδι σου στον κόσμο των δημιουργιών του El Greco."; 
        }
         else if (location == 16 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("12.png", 29);
            String res = createAndDisplayGUI(29);
            if (res.equals(model[29].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 16 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(16);
                
                Icon icon = new ImageIcon(getClass().getResource("13.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Ο Ευαγγελισμός");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
         else if (location == 17 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("13.png", 30);
            String res = createAndDisplayGUI(30);
            if (res.equals(model[30].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 17 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(17);
                
                Icon icon = new ImageIcon(getClass().getResource("14.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Το μαρτύριο του Αγίου Μαυρικίου");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 18 )
        {
            if (playerModelUnit.isSuperBonusFlag() == false){
            
                message1 = "έχεις ήδη απαντήσει μια φορά σε superbonus ερώτηση.";
                message2 = "δε μπορείς να απαντήσεις άλλη φορά.";
            }
            else
            {
            
                message1 = "Απάντησε την ερώτηση";
                final Random rand = new Random();
                int j = rand.nextInt(6) + 47;
                String res = createAndDisplayGUI(j-1);
                if (res.equals(model[j-1].getRightAnswer()))
                {
                    message1 = "Απάντησες σωστά.";
                    message2 = "Δωρεάν είσοδος στον επόμενο χώρο έκθεσης έργου!";
                    location = 19;
                    playerModelUnit.setSuperBonusFlag(false);
                }
                else
                {
                    message1 = "Απάντησες λάθος.";
                    message2 = "Μένεις στην ίδια θέση!";
//                    playerModelUnit.deductMoney(5);
                    playerModelUnit.setSuperBonusFlag(false);
                }
            
            }
        }
        
        else if (location == 19 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("14.png", 31);
            String res = createAndDisplayGUI(31);
            if (res.equals(model[31].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 20 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(20);
                
                Icon icon = new ImageIcon(getClass().getResource("15.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η Ανάσταση");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 20 )
        {
             message1 = "Είσαι στη θέση Εντευκτήριο και θα παραμείνεις ";
            message2 = "για να εμπλουτίσεις τις γνώσεις σου για τον El Greco!";
//            JEditorPane ep = new JEditorPane
           final URI uri = new URI("https://drive.google.com/file/d/0B3yBhORvYxPYNXJQc3RiSVJ0ajA/edit");
           final JFrame frame = new JFrame("Υπερσύνδεσμος για Ελ Γκρέκο ");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(500, 100);
            frame.setLocation(300, 100);
//            frame.
            Container container = frame.getContentPane();
            container.setLayout(new GridBagLayout());
            final JButton button = new JButton();
            button.setText("<HTML>Κλίκαρε τον <FONT color=\"#000099\"><U>Σύνδεσμο</U></FONT>"
                + " για Ελ Γκρέκο.</HTML>");
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setBorderPainted(false);
            button.setOpaque(false);
            button.setBackground(Color.WHITE);
            button.setToolTipText(uri.toString());
            
            class OpenUrlAction implements ActionListener {
            @Override public void actionPerformed(ActionEvent e) {
             if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(uri);
      }
      catch (IOException ex) { /* TODO: error handling */ }
    } else { /* TODO: error handling */ }
             if(e.getSource() == button){frame.dispose();}
            }
          }
           button.addActionListener(new OpenUrlAction());
            container.add(button);
            frame.setVisible(true); 
            
        }
        else if (location == 21 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("15.png", 32);
            String res = createAndDisplayGUI(32);
            if (res.equals(model[32].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 20 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(20);
               
                Icon icon = new ImageIcon(getClass().getResource("16.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η Αγία Τριάδα");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
         else if (location == 22 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("16.png", 33);
            String res = createAndDisplayGUI(33);
            if (res.equals(model[33].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 20 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(20);
                
                Icon icon = new ImageIcon(getClass().getResource("17.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η Σταύρωση");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
         else if (location == 23 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("17.png", 34);
            String res = createAndDisplayGUI(34);
            if (res.equals(model[34].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 20 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(20);
                
                Icon icon = new ImageIcon(getClass().getResource("18.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Ο ιππότης με το χέρι στο στήθος");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 24 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("18.png", 35);
            String res = createAndDisplayGUI(35);
            if (res.equals(model[35].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 20 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(20);
                
                Icon icon = new ImageIcon(getClass().getResource("24.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η Πεντηκοστή");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 25 )
        {
            message1 = "Είσαι στη θέση Υποργείο Πολιτισμού Ισπανίας";
            message2 = "και θα δεχτείς οικονομική ενίσχυση 25 δουκάτων!";
            playerModelUnit.addMoney(25);
            
        }
        else if (location == 26 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("19.png", 36);
            String res = createAndDisplayGUI(36);
            if (res.equals(model[36].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 22 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(22);
                
                Icon icon = new ImageIcon(getClass().getResource("19.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Ο διαμερισμός των ιματίων");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        
        else if (location == 27 )
        {
            message1 = "Απάντησε τη bonus ερώτηση";
            final Random rand = new Random();
            int i = rand.nextInt(19)+1;
            String res = createAndDisplayGUI(i-1);
            if (res.equals(model[i-1].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Σου προστίθενται 15 δουκάτα!";
                playerModelUnit.addMoney(15);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Μένεις στην ίδια θέση!";
            }
        }
        else if (location == 28 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("20.png", 37);
            String res = createAndDisplayGUI(37);
            if (res.equals(model[37].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 25 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(25);
                
                Icon icon = new ImageIcon(getClass().getResource("20.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η ταφή του κόμητος Οργκάθ");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 29 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("21.png", 38);
            String res = createAndDisplayGUI(38);
            if (res.equals(model[38].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 26 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(26);
                
                Icon icon = new ImageIcon(getClass().getResource("21.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η Αγία Οικογένεια με την Αγία Άννα");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 30 )
        {
            message1 = "Θα μεταβείς στη θέση: ";
            message2 = " <<Βιβλίο κανονισμού επίσκεψης μουσείων και εκθεσιακών χώρων>>";
            location = 10;
        }
        else if (location == 31 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
            String res = createAndDisplayGUI(39);
            if (res.equals(model[39].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 28 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(28);
                Icon icon = new ImageIcon(getClass().getResource("31.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η εκδίωξη των εμπόρων από το Ναό");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
                
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 32 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("22.png", 40);
            String res = createAndDisplayGUI(40);
            if (res.equals(model[40].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 30 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(30);
                
                Icon icon = new ImageIcon(getClass().getResource("22.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Ο Καρδινάλιος Νίνιο ντε Γκεβάρα");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 33 )
        {
             message1 = "Απάντησε τη bonus ερώτηση";
            final Random rand = new Random();
            int i = rand.nextInt(19)+1;
            String res = createAndDisplayGUI(i-1);
            if (res.equals(model[i-1].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Σου προστίθενται 15 δουκάτα!";
                playerModelUnit.addMoney(15);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Μένεις στην ίδια θέση!";
            }
        }
        else if (location == 34 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("23.png", 41);
            String res = createAndDisplayGUI(41);
            if (res.equals(model[41].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 30 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(30);
                
                Icon icon = new ImageIcon(getClass().getResource("23.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Ο Χριστός αίρων το Σταυρό");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 35 )
        {
            message1 = "Είσαι στη θέση Υποργείο Πολιτισμού ΗΠΑ";
            message2 = "και θα δεχτείς οικονομική ενίσχυση 25 δουκάτων!";
            playerModelUnit.addMoney(25);
            
        }
        else if (location == 36 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("24.png", 42);
            String res = createAndDisplayGUI(42);
            if (res.equals(model[42].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 30 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(30);
                
                Icon icon = new ImageIcon(getClass().getResource("24.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Η Πέμπτη Σφραγίδα της Αποκαλύψεως");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
        else if (location == 37 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("25.png", 43);
            String res = createAndDisplayGUI(43);
            if (res.equals(model[43].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 32 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(32);
                Icon icon = new ImageIcon(getClass().getResource("26.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, " Άποψη του Τολέδο");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
                
                
            }
        }
        else if (location == 38 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("26.png", 44);
            String res = createAndDisplayGUI(44);
            if (res.equals(model[44].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 35 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(35);
                Icon icon = new ImageIcon(getClass().getResource("26.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Άποψη του Τολέδο");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }
         else if (location == 39 )
        {
            message1 = "Απάντησε την ερώτηση";
//            final Random rand = new Random();
//            String res = createAndDisplayGUI("27.png", 45);
            String res = createAndDisplayGUI(45);
            if (res.equals(model[45].getRightAnswer()))
            {
                message1 = "Απάντησες σωστά.";
                message2 = "Πλήρωσε 35 δουκάτα για εισιτήριο!";
                playerModelUnit.deductMoney(35);
                Icon icon = new ImageIcon(getClass().getResource("27.png"));
            JOptionPane optionPane = new JOptionPane(null
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
            optionPane.setWantsInput(false);             
            JDialog dialog = optionPane.createDialog(null, "Ο Άγιος Μαρτίνος μοιράζεται το μανδύα του με ένα ζητιάνο");
            dialog.setLocation(200, 80);
            dialog.setVisible(true);
            }
            else
            {
                message1 = "Απάντησες λάθος.";
                message2 = "Σου αφαιρούνται 5 δουκάτα!";
                playerModelUnit.deductMoney(5);
            }
        }


        // Place icons in new locations.
        playerModelUnit.setLocation(location);
        board.getTiles()[location].getTilePanel().getPlayerItem().revealPlayerItem(playerModelUnit.getPlayerId());

        }

    public void createRollPanel(PlayerModel playerModelUnit) {
        // Remove old data.
        rollPanel.removeAll();
        rollPanel.revalidate();
        rollPanel.repaint();
        //initialize JFrame
        rollWindow.setTitle("Ρίξε ζάρι");
        rollWindow.setSize(new Dimension(400, 200));
        rollWindow.setResizable(true);
        rollWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        rollWindow.setLocationRelativeTo(null);
        rollWindow.setVisible(true);
        rollWindow.setAlwaysOnTop(false);

        // Display any messages.
        JLabel messageLabel1 = new JLabel(message1);
        messageLabel1.setHorizontalAlignment(JLabel.CENTER);
        JLabel messageLabel2 = new JLabel(message2);
        messageLabel2.setHorizontalAlignment(JLabel.CENTER);
        // Display player name.
        JLabel playerName = new JLabel("Παίκτης: " + playerModelUnit.name);
        playerName.setHorizontalAlignment(JLabel.CENTER);
        // Display player money.
        JLabel playerMoney = new JLabel("Τρεχούμενα Χρήματα: Δουκάτα " + String.valueOf(playerModelUnit.getMoney()));
        playerMoney.setHorizontalAlignment(JLabel.CENTER);
        // Display what the player rolled.
        JLabel dieDisplay = new JLabel(" Έριξες: " + String.valueOf(dieTemp));
        dieDisplay.setHorizontalAlignment(JLabel.CENTER);
        // Add roll button.
        RollHandler rollAction = new RollHandler();
        JButton rollButton = new JButton("Τέλος Σειράς");
        rollButton.addActionListener(rollAction);

        if (!"".equals(message1))
            rollPanel.add(messageLabel1);
        if (!"".equals(message2))
            rollPanel.add(messageLabel2);

        rollPanel.add(playerName);
        rollPanel.add(playerMoney);
        rollPanel.add(dieDisplay);
        rollPanel.add(rollButton);
        rollWindow.add(rollPanel);

        message1 = "";
        message2 = "";

    }
    
    public void createRollPanel(String message1, String message2){
//    // Remove old data.
        rollPanel.removeAll();
        rollPanel.revalidate();
        rollPanel.repaint();
        //initialize JFrame
        rollWindow.setTitle("Roll");
        rollWindow.setSize(new Dimension(220, 200));
        rollWindow.setResizable(false);
        rollWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        rollWindow.setLocationRelativeTo(null);
        rollWindow.setVisible(true);
        rollWindow.setAlwaysOnTop(false);

        // Display any messages.
        JLabel messageLabel1 = new JLabel(message1);
        messageLabel1.setHorizontalAlignment(JLabel.CENTER);
        JLabel messageLabel2 = new JLabel(message2);
        messageLabel2.setHorizontalAlignment(JLabel.CENTER);
        // Display player name.
//        JLabel playerName = new JLabel("Player: " + playerModelUnit.name);
//        playerName.setHorizontalAlignment(JLabel.CENTER);
        // Display player money.
//        JLabel playerMoney = new JLabel("Current Cash: €" + String.valueOf(playerModelUnit.getMoney()));
//        playerMoney.setHorizontalAlignment(JLabel.CENTER);
        // Display what the player rolled.
//        JLabel dieDisplay = new JLabel("You rolled: " + String.valueOf(dieTemp));
//        dieDisplay.setHorizontalAlignment(JLabel.CENTER);
        // Add roll button.
        RollHandler rollAction = new RollHandler();
        JButton rollButton = new JButton("Ρίξε ζάρι");
        rollButton.addActionListener(rollAction);

        if (!"".equals(message1))
            rollPanel.add(messageLabel1);
        if (!"".equals(message2))
            rollPanel.add(messageLabel2);

//        rollPanel.add(playerName);
//        rollPanel.add(playerMoney);
//        rollPanel.add(dieDisplay);
        rollPanel.add(rollButton);
        rollWindow.add(rollPanel);

        message1 = "";
        message2 = "";
    
    }

    
    public class RollHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            turnEnd = true;
        }
    }
    
    
    public String createAndDisplayGUI(int i)
    {   
//         Random rand = new Random();
//        Question model = new Question(rand.nextInt(18) + 1);
//        model.setQuestionId(rand.nextInt(3) + 1);
//        model = new Question(rand.nextInt(18) + 1);
//        Icon icon = new ImageIcon(getClass().getResource("rsz_greco.png"));
        JOptionPane optionPane = new JOptionPane(model[i].getQuestionText() +
                    "\n" + model[i].getAnswer1() +
                    "\n" + model[i].getAnswer2() +
                    "\n" + model[i].getAnswer3() +
                    "\n" + model[i].getAnswer4()
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , null, null, null);
        optionPane.setWantsInput(true);             
        JDialog dialog = optionPane.createDialog(null, "Ερώτηση");
        dialog.setLocation(500, 80);
        dialog.setVisible(true);
        return (String)optionPane.getInputValue();
    }
    
     public String createAndDisplayGUI(String imageName, int i)
    {   
//         Random rand = new Random();
//        Question model = new Question(rand.nextInt(18) + 1);
//        model.setQuestionId(rand.nextInt(3) + 1);
//        model = new Question(rand.nextInt(18) + 1);
        Icon icon = new ImageIcon(getClass().getResource(imageName));
        JOptionPane optionPane = new JOptionPane(model[i].getQuestionText() +
                    "\n" + model[i].getAnswer1() +
                    "\n" + model[i].getAnswer2() +
                    "\n" + model[i].getAnswer3() +
                    "\n" + model[i].getAnswer4()
                                    , JOptionPane.PLAIN_MESSAGE
                                    , JOptionPane.DEFAULT_OPTION
                                    , icon, null, null);
        optionPane.setWantsInput(true);             
        JDialog dialog = optionPane.createDialog(null, "Θεοτοκόπολη Ερώτηση");
        dialog.setLocation(100, 80);
        dialog.setVisible(true);
        return (String)optionPane.getInputValue();
    }
    
//    public String createAndDisplayGUI(int i)
//    {   
////         Random rand = new Random();
////        Question model = new Question(rand.nextInt(18) + 1);
////        model.setQuestionId(rand.nextInt(3) + 1);
////        model = new Question(rand.nextInt(18) + 1);
//        JOptionPane optionPane = new JOptionPane(new JRadioButton(model[i].getQuestionText()) +
//                    "\n" + new JRadioButton(model[i].getAnswer1()) +
//                    "\n" + new JRadioButton(model[i].getAnswer2()) +
//                    "\n" + new JRadioButton(model[i].getAnswer3()) +
//                    "\n" + new JRadioButton(model[i].getAnswer4())
//                                    , JOptionPane.PLAIN_MESSAGE
//                                    , JOptionPane.DEFAULT_OPTION
//                                    , null, null, null);
//        optionPane.setWantsInput(true);             
//        JDialog dialog = optionPane.createDialog(null, "Patreopolis question");
//        dialog.setLocation(500, 80);
//        dialog.setVisible(true);
//        return (String)optionPane.getInputValue();
//    }

    
    
    
}



//    public void createQuestionPanel(player playerUnit) {
//        // Remove old data.
////        rollPanel2.removeAll();
////        rollPanel2.revalidate();
////        rollPanel2.repaint();
//        //initialize JFrame
//        rollWindow.setTitle("Question");
//        rollWindow.setSize(new Dimension(440, 400));
//        rollWindow.setResizable(false);
//        rollWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
//        rollWindow.setLocationRelativeTo(null);
//        rollWindow.setVisible(true);
//        rollWindow.setAlwaysOnTop(true);
//
//        HashMap<Integer, String> map = new HashMap<Integer , String>();
//        map.put(1, "Question ID");
//        map.put(2, "In which street we meet the archaeological museum of Patras?");
//        map.put(3, "Korinthou-Athinon National Road");
//        map.put(4, "Corinthou Street");
//        map.put(5, "Mezonos Street");
//        map.put(6, "Germanou Street");
//        map.put(7, "Correct answer is: ");
//
//        // Display player question.
//        JLabel playerQuestion = new JLabel("Question: " + map.get(0));
//        playerQuestion.setHorizontalAlignment(JLabel.CENTER);
//        // Display player answer1.
//        JLabel playerAnswer1 = new JLabel("Answer 1: " + map.get(3));
//        playerAnswer1.setHorizontalAlignment(JLabel.CENTER);
//        // Display player answer2.
//        JLabel playerAnswer2 = new JLabel("Answer 2: " + map.get(4));
//        playerAnswer2.setHorizontalAlignment(JLabel.CENTER);
//        // Display player answer1.
//        JLabel playerAnswer3 = new JLabel("Answer 3: " + map.get(5));
//        playerAnswer3.setHorizontalAlignment(JLabel.CENTER);
//        // Display player answer1.
//        JLabel playerAnswer4 = new JLabel("Answer 4: " + map.get(6));
//        playerAnswer4.setHorizontalAlignment(JLabel.CENTER);
//        JLabel chooseAnswer = new JLabel("The correct answer is number: ");
//        chooseAnswer.setHorizontalAlignment(JLabel.CENTER);
//        JTextField textField = new JTextField(20);
//
//        // Add roll button.
//        RollHandler rollAction = new RollHandler();
//        JButton rollButton2 = new JButton("OK");
//        rollButton2.addActionListener(rollAction);
//
//        rollPanel.add(playerQuestion);
//        rollPanel.add(playerAnswer1);
//        rollPanel.add(playerAnswer2);
//        rollPanel.add(playerAnswer3);
//        rollPanel.add(playerAnswer4);
//        rollPanel.add(chooseAnswer);
//        rollPanel.add(textField);
//        rollPanel.add(rollButton2);
//        rollWindow.add(rollPanel);
//    public void actionPerformed(ActionEvent event) {
//        if(event.getSource() == rollButton2){
//            if(textfield.getText().equals("1")) {
//                answer = Integer.parseInt(textfield.getText());
//                textfield.setText("");
//                rollButton2.setEnabled(false);
//
//            }
//        }


//    }


//    }



