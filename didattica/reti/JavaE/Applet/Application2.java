import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Application2 extends Applet2 {

public static void main(String args[]) {
  Application2 applet = new Application2();
  JFrame f = new JFrame(
  applet.getClass().getName() );
  f.setSize(new Dimension(300,100));
  f.addWindowListener( new Terminator() );
  Container c = f.getContentPane();
  c.add(applet);
  applet.init(); // non c'Š start();
  f.show();
  }
  // qui c'Š anche la classe Terminator
}

