
import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
 public void paintComponent(Graphics g){
super.paintComponent(g);
g.setColor(Color.red);
      // white, gray, lightGray, darkGray
     // red, green, yellow, pink, etc. etc.
g.fillRect(20,20, 100,80);
g.setColor(Color.blue);
g.drawRect(30,30,  80,60);
g.setColor(Color.black);
g.drawString("ciao",50,60);
}
}

