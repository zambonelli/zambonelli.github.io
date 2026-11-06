import java.awt.*; import javax.swing.*;
import java.awt.event.*;
// bisogna importare il package degli eventi!

public class EsSwing9 {
 public static void main(String[] v){
   JFrame f = new JFrame("Esempio 7");
   Container c = f.getContentPane();
   Es9Panel p = new Es9Panel();
   c.add(p);
   f.addWindowListener( new Terminator() );
  // Terminator Š la classe che implementa
  // l'interfaccia WindowListener
       f.pack();

   f.pack(); f.show();
    }
}

