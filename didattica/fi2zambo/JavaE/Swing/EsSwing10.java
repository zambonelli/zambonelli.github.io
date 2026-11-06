import java.awt.*; import javax.swing.*;
import java.awt.event.*;
// bisogna importare il package degli eventi!

public class EsSwing10 {
 public static void main(String[] v){
   JFrame f = new JFrame("Esempio 7");
   Container c = f.getContentPane();
   Es10Panel p = new Es10Panel();
   c.add(p);
   f.addWindowListener( new Terminator() );
  // Terminator Š la classe che implementa
  // l'interfaccia WindowListener

   f.pack(); f.show();
    }
}

