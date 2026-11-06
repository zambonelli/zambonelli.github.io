import java.awt.*; import javax.swing.*;
public class EsSwing4 {
public static void main(String[] v){
MyFrame f = new MyFrame("Esempio 4");
// potremmo anche usare un JFrame standard_
Container c = f.getContentPane();
MyPanel panel = new MyPanel();
c.add(panel);
f.show();
}
}

