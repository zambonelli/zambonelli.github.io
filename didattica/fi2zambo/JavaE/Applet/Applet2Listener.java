import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class Applet2Listener implements ActionListener {
 JApplet app;  Color colore; JTextField txt;
  Applet2Listener(JApplet a, Color c, JTextField t){
  app = a; colore = c; txt = t;
  }
  public void actionPerformed(ActionEvent e){
  app.getContentPane().setBackground(colore);
  txt.setText("Premuto il pulsante " +
  e.getActionCommand());
  app.repaint();
  }
}


