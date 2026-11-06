import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class Es13Panel extends JPanel
implements ItemListener {

JTextField txt; JCheckBox ck1;

public Es13Panel(){
  super();
  txt = new JTextField(10);
  txt.setEditable(false);
  ck1 = new JCheckBox("Opzione");
  ck1.addItemListener(this);
  add(ck1); add(txt);
    }

public void itemStateChanged(ItemEvent e){
  if (ck1.isSelected())
        txt.setText("Opzione attivata");
  else  txt.setText("Opzione disattivata");
    }
}


