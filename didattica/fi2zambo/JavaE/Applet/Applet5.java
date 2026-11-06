import java.applet.*;
import java.awt.*;
import javax.swing.*;


public class Applet5 extends JApplet {
JButton redButton, blueButton, greenButton;
JTextField  messaggio;

public void init() {
   Container c = getContentPane();
    // il contenitore che contiene la applet
   c.setBackground(SystemColor.window);
   c.setLayout(new FlowLayout());
   redButton   = new JButton("Rosso");
   blueButton  = new JButton("Azzurro");
   greenButton = new JButton("Verde");
   messaggio   = new JTextField(26);
   messaggio.setText("Premere un pulsante");
   messaggio.setEditable(false);

   // i componenti non vanno aggiunti alla applet
   // ma al contenitore che la contiene
   c.add(messaggio);  c.add(redButton);
   c.add(blueButton); c.add(greenButton);
   redButton.addActionListener(new
   Applet2Listener(this, Color.red, messaggio));
   blueButton.addActionListener(new
   Applet2Listener(this, Color.cyan, messaggio));
   greenButton.addActionListener(new
   Applet2Listener(this, Color.green, messaggio));
   }

public static void main(String args[]) {
  Applet5 applet = new Applet5();
  JFrame f = new JFrame(
  applet.getClass().getName() );
  //TITOLO = NOME CLASSE
  f.setSize(new Dimension(300,100));
  f.addWindowListener( new Terminator() );
  Container c = f.getContentPane();
  c.add(applet);
  applet.init(); // non c'Š start();
  f.show();  }

}




