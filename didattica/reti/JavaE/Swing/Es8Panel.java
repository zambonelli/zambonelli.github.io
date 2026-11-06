import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Es8Panel extends JPanel
implements ActionListener{
private JLabel l;
public Es8Panel(){
  super();
  l = new JLabel("Tizio");
  add(l);
  JButton b = new JButton("Tizio/Caio");
  // Tizio/Caio Š l'etichetta del pulsante
  b.addActionListener(this);
  // registra l'oggetto panel stesso come
  // ascoltatore degli eventi
  add(b);
  }


public void actionPerformed(ActionEvent e){
  if (l.getText().equals("Tizio"))
        l.setText("Caio");
  else
        l.setText("Tizio");
    }


}


