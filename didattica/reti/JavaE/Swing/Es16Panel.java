import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Es16Panel extends JPanel
implements ListSelectionListener {

JTextField txt;  JList list;

public Es16Panel(){
  super();
  txt  = new JTextField(15);
  txt.setEditable(false);
  String voci[]={"Rosso","Giallo","Verde", "Blu"};
  list = new JList(voci);
  list.addListSelectionListener(this);
  add(list); add(txt);
  }

  public void valueChanged(ListSelectionEvent e){
  String scelta = (String) list.getSelectedValue();
  txt.setText("Scelta corrente: " + scelta);
  }

}


