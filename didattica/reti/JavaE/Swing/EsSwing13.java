import java.awt.*; import javax.swing.*;
import java.awt.event.*;
// bisogna importare il package degli eventi!

public class EsSwing13 {
 public static void main(String[] v){
   JFrame f = new JFrame("Esempio 13");
   Container c = f.getContentPane();
   Es13Panel p = new Es13Panel();
   c.add(p);
   f.addWindowListener( new Terminator() );
  // Terminator Š la classe che implementa
  // l'interfaccia WindowListener

   f.pack(); f.show();
    }
}

