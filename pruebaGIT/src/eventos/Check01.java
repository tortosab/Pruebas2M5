package eventos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Check01 extends JFrame {

     public Check01() {  //constructor
 
          ElMeuPanel panel=new ElMeuPanel();
         add(panel,BorderLayout.CENTER); 
      /*    addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {
                 dispose();
                 System.exit(0);
             }
         });*/
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     } 
    public static void main(String args[]) {

         Check01 mainFrame = new Check01();
 
          mainFrame.setSize(400, 100);
         mainFrame.setTitle("Checkboxes"); 
          mainFrame.setVisible(true);
          System.out.println("Començant 55");
     }
 }
 
  class ElMeuPanel extends JPanel implements ItemListener {

     JLabel label;
     
     public ElMeuPanel() {  //constructor
         super();
         this.setLayout(new BorderLayout());
         label=new JLabel("Juguem amb Checkboxes...",JLabel.CENTER);
         label.setOpaque(true);
         add(label,BorderLayout.CENTER);
         JPanel panel=new JPanel();
         panel.setLayout(new GridLayout(4,1));
         JCheckBox chbox_1=new JCheckBox("Color");
         chbox_1.addItemListener(this);
         panel.add(chbox_1);
         JCheckBox chbox_2=new JCheckBox("Negreta");
         chbox_2.addItemListener(this);
         panel.add(chbox_2);
         JCheckBox chbox_3=new JCheckBox("Inclinada");
         chbox_3.addItemListener(this);
         panel.add(chbox_3);
         JCheckBox chbox_4=new JCheckBox("Gran");
         chbox_4.addItemListener(this);
         panel.add(chbox_4);
         add(panel,BorderLayout.EAST);
     }

     public void itemStateChanged(ItemEvent e) {
         Object checkObj=e.getSource();
             if (checkObj instanceof JCheckBox) {
            	 JCheckBox chbox=(JCheckBox)checkObj;
                 String lblCb=chbox.getText();
                 boolean state=chbox.isSelected();
                     if (lblCb=="Color") {
                             if (state) {
                                 label.setBackground(Color.pink);
                             } else {
                                 label.setBackground(Color.white);
                             }
                     } else if (lblCb=="Negreta") {
                         Font font=label.getFont();
                         int style=font.getStyle();
                             if (state) {
                                 style=style+Font.BOLD;
                             } else {
                                 style=style-Font.BOLD;
                             }
                         font=font.deriveFont(style);
                         label.setFont(font);
                     } else if (lblCb=="Inclinada") {
                         Font font=label.getFont();
                         int style=font.getStyle();
                             if (state) {
                                 style=style+Font.ITALIC;
                             } else {
                                 style=style-Font.ITALIC;
                             }
                         font=font.deriveFont(style);
                         label.setFont(font);
                     } else if (lblCb=="Gran") {
                         Font font=label.getFont();
                         float size=font.getSize2D();
                             if (state) {
                                 size=2.0f*size;
                             } else {
                                 size=0.5f*size;
                             }
                         font=font.deriveFont(size);
                         label.setFont(font);
                     }
             }
     }

 } 

