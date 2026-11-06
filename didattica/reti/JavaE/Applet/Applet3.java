import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Applet3 extends JApplet {
JButton deleteButton, editButton;
JTextArea ta; JTextField tf;
int pos, endPos;

public void init() {
    Container c = getContentPane();
   // ricordiamo che si opera sul container e non
   // sulla applet
   c.setBackground(Color.blue);
   c.setLayout(new
   FlowLayout(FlowLayout.CENTER,10,10));
   deleteButton = new JButton("Elimina");
   editButton   = new JButton("Modifica");
   ta = new JTextArea("",12,40);
   tf = new JTextField("",40);

   c.add(ta); c.add(tf);
   c.add(editButton); c.add(deleteButton);
   Applet3Listener editor = new
   Applet3Listener(ta,tf);
   editButton.addActionListener(editor);
   deleteButton.addActionListener(editor);
   }
}

