package com.telis.patreopolis;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class BoardPanel extends JPanel {
private BufferedImage image;
    
    BoardPanel(Tile[] tiles) {

        //BoxLayout(Container target, int axis)
        //Y_AXIS - Components are laid out vertically from top to bottom.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // parameters of Flowlayout: align, horizontal gap, vertical gap
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        //parameters of Dimension (int width, int height)
        topPanel.setPreferredSize(new Dimension(0,90));
        topPanel.add(tiles[20].getTilePanel());
        topPanel.add(tiles[21].getTilePanel());
        topPanel.add(tiles[22].getTilePanel());
        topPanel.add(tiles[23].getTilePanel());
        topPanel.add(tiles[24].getTilePanel());
        topPanel.add(tiles[25].getTilePanel());
        topPanel.add(tiles[26].getTilePanel());
        topPanel.add(tiles[27].getTilePanel());
        topPanel.add(tiles[28].getTilePanel());
        topPanel.add(tiles[29].getTilePanel());
        topPanel.add(tiles[30].getTilePanel());

        //JPanel(LayoutManager layout)
        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        //GridLayout(int rows, int cols)
        JPanel leftPanel = new JPanel(new GridLayout(0,1));
        leftPanel.add(tiles[19].getTilePanel());
        leftPanel.add(tiles[18].getTilePanel());
        leftPanel.add(tiles[17].getTilePanel());
        leftPanel.add(tiles[16].getTilePanel());
        leftPanel.add(tiles[15].getTilePanel());
        leftPanel.add(tiles[14].getTilePanel());
        leftPanel.add(tiles[13].getTilePanel());
        leftPanel.add(tiles[12].getTilePanel());
        leftPanel.add(tiles[11].getTilePanel());

        //Creates a new JPanel with a double buffer and a flow layout.
        //BoxLayout(Container target, int axis)
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        ImageIcon icon = new ImageIcon("1.png");
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

         try {
            image = ImageIO.read(new File("C:\\Users\\trian\\Documents\\NetBeansProjects\\ElGreco\\3t.png"));
        } catch(IOException ex){ex.printStackTrace();}
        
        
/*                 logo JTextPane                                                 */
        
//        JTextPane logo = new JTextPane();
//        logo.setEditable(false);
//        JLabel logoText = new JLabel("El Greco: τα ταξίδια της ζωής και του έργου του", JLabel.CENTER);
//        
//    
//        logoText.setFont(new Font("Arial", Font.BOLD, 28));
//        logo.setPreferredSize(new Dimension(808, 808));
//        
//        String html_text = "";
                
//                "<html>Κανόνες: "
//                + "<BR>- Κάθε παίκτης ξεκινάει παίρνοντας 150 δουκάτα από τη τράπεζα"
//                + "<BR>- Σε περίπτωση σωστής απάντησης περιηγείται το χώρο του εκάστοτε έργου. Αν η απάντηση είναι λάθος του αφαιρούνται 5 δουκάτα"
//                + "<BR>- Στην bonus ερώτηση προστίθενται 15 δουκάτα  αν είναι σωστή η απάντηση αλλιώς μένει στην ίδια θέση"
//                + "<BR>- Στην superbonus ερώτηση περιηγείται τον αμέσως επόμενο χώρο για να δει το έργο αν η απάντηση είναι σωστή"
//                + "<BR>- Αλλιώς μένει εκεί που είναι. Κάθε παίκτης έχει δικαίωμα να απάντήσει μόνο σε μια superbonus ερώτηση στο παιχνίδι "
//                + "<BR>- Αν βρεθεί στη θέση υπουργείο πολιτισμού δέχεται οικονομική ενίσχυση 25 δουκάτων."
//                + "<BR>- Αν κάποιος παίκτης βρεθεί στη θέση 'Διάβασε το Βιβλίο κανονισμού επίσκεψης μουσείων και εκθεσιακών χώρων' " 
//                + "<BR>    οφείλει να μεταβεί στη θέση 'Βιβλίο κανονισμού επίσκεψης μουσείων και εκθεσιακών χώρων' και να μελετήσει το βιβλίο αυτό."
//                + "<BR>- Αν κάποιος παίκτης βρεθεί στη θέση 'Βιβλίο κανονισμού επίσκεψης μουσείων και εκθεσιακών χώρων' παραμένει στη θέση αυτή" 
//                + "<BR>    μέχρι τον επόμενο γύρο."
//                + "<BR>- Κάθε φορά που κάποιος παίκτης περνά από την 'Αφετηρία' προστίθενται στο λογαριασμό του 20 δουκάτα."
//                + "</HTML>  ";
        ImageIcon image = new ImageIcon ("C:\\Users\\trian\\Documents\\NetBeansProjects\\ElGreco\\3t.png"); 
        JLabel logoText2 = new JLabel(image, JLabel.CENTER);
//        JLabel logoText2 = new JLabel(html_text, JLabel.CENTER);
//        logo.insertComponent(logoText2);
//        logo.insertComponent(logoText);
//        StyledDocument doc = logo.getStyledDocument();
        SimpleAttributeSet centerText = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
         //public void insertString(int offset, String str, AttributeSet a) throws BadLocationException
//        try {
//            doc.insertString(0, "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
//                                "\n\n\n\n\n", centerText);
//        } catch (BadLocationException e) {
//            e.printStackTrace();
//        }
//        doc.setParagraphAttributes(0, doc.getLength(), centerText, false);
        //        public void setParagraphAttributes(int offset, int length, AttributeSet s, boolean replace)
        middlePanel.add(logoText2);
//        middlePanel.add(logo);
        
        /*          LOGO2 JTextPane                    */
        
//        JTextPane logo2 = new JTextPane();
//        logo2.setEditable(false);
//        JLabel logoText2 = new JLabel(""
//                + " Rules: "
//                + "\n"
//                + "monuments-> you pay money, \n"
//                + "command-> move forward to a position\n"
//                + "\nquestion-> you answer question and if right you move on to the next monument"
//                + "\nfree parking-> ", JLabel.CENTER);
//        logo2.setPreferredSize(new Dimension(898, 1038));
//        logo2.insertComponent(logoText2);
//        StyledDocument doc2 = logo2.getStyledDocument();
//        SimpleAttributeSet centerText2 = new SimpleAttributeSet();
//        StyleConstants.setAlignment(centerText2, StyleConstants.ALIGN_CENTER);
//        try {
//            //public void insertString(int offset, String str, AttributeSet a) throws BadLocationException
//            doc2.insertString(0, "" +
//                                "\n", centerText2);
//        } catch (BadLocationException e) {
//            e.printStackTrace();
//        }
//        doc2.setParagraphAttributes(0, doc2.getLength(), centerText2, false);
//        middlePanel.add(logo2, BorderLayout.CENTER);



        
        
        
        
        
        
        

        JPanel rightPanel = new JPanel(new GridLayout(0,1));
        rightPanel.add(tiles[31].getTilePanel());
        rightPanel.add(tiles[32].getTilePanel());
        rightPanel.add(tiles[33].getTilePanel());
        rightPanel.add(tiles[34].getTilePanel());
        rightPanel.add(tiles[35].getTilePanel());
        rightPanel.add(tiles[36].getTilePanel());
        rightPanel.add(tiles[37].getTilePanel());
        rightPanel.add(tiles[38].getTilePanel());
        rightPanel.add(tiles[39].getTilePanel());

        center.add(leftPanel);
        center.add(middlePanel);
        center.add(rightPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,-1));
        bottomPanel.add(tiles[10].getTilePanel());
        bottomPanel.add(tiles[9].getTilePanel());
        bottomPanel.add(tiles[8].getTilePanel());
        bottomPanel.add(tiles[7].getTilePanel());
        bottomPanel.add(tiles[6].getTilePanel());
        bottomPanel.add(tiles[5].getTilePanel());
        bottomPanel.add(tiles[4].getTilePanel());
        bottomPanel.add(tiles[3].getTilePanel());
        bottomPanel.add(tiles[2].getTilePanel());
        bottomPanel.add(tiles[1].getTilePanel());
        bottomPanel.add(tiles[0].getTilePanel());
        
        
//        JLabel testimg = new JLabel(new ImageIcon(getClass().getResource("2.png")));
//        testimg.setLocation(-500, 300);
        
        add(topPanel);
        add(center);
        add(bottomPanel);
//        add(testimg);
    }
}
