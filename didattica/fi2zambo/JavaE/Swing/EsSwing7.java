import java.awt.*;
import javax.swing.*;

public class EsSwing7 {
public static void main(String[] v){
JFrame f = new JFrame("Esempio 7");
Container c = f.getContentPane();
Es7Panel p = new Es7Panel();
c.add(p);
f.pack();
//pack dimensiona il frame in modo da
//contenere esattamente il pannello
f.show();
  }
}

