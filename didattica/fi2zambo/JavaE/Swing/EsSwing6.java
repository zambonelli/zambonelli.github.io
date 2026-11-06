import java.awt.*; import javax.swing.*;

public class EsSwing6 {
public static void main(String[] v){
JFrame f = new JFrame("The MOON");
Container c = f.getContentPane();
ImgPanel p = new ImgPanel();
c.add(p);
f.setBounds(100,100,500,400);
f.show();
}
}

