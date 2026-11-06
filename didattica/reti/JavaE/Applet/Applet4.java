import java.applet.*;
import java.awt.*;
import javax.swing.*;

public class Applet4 extends JApplet {
Font f = new Font("Times", Font.BOLD, 36);

public void paint(Graphics g) {
  g.setFont(f);
  g.setColor(Color.red);
  g.drawString(getParameter("Frase"), 100, 50);
  }
}

