import java.applet.*;
import java.awt.*;
import javax.swing.*;

public class Applet1 extends JApplet {
Font f = new Font("Times", Font.BOLD, 36);
 public void paint(Graphics g) {
 g.setFont(f);
 g.setColor(Color.red);
 g.drawString("Ciao mondo!", 100, 50);
 // non implementa i metodi init, start, stop
  }
}

