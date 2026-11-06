import java.awt.*; import javax.swing.*;
import java.awt.event.*;


public class EsSwing16 {

public static void main(String[] v){
   JFrame f = new JFrame("Esempio 16");
   Container c = f.getContentPane();
   Es16Panel p = new Es16Panel();
   c.add(p);
   f.addWindowListener( new Terminator() );
  // Terminator Š la classe che implementa
  // l'interfaccia WindowListener
   f.pack(); f.show();
   }
}

