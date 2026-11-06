import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class Es14Panel extends JPanel
implements ItemListener {

JTextField txt1, txt2;
JCheckBox c1, c2;

public Es14Panel(){
  super();
  txt1 = new JTextField(15);
  txt1.setEditable(false);
  txt2 = new JTextField(15);
  txt2.setEditable(false);
  c1 = new JCheckBox("Mele");
  c1.addItemListener(this);
  c2 = new JCheckBox("Pere");
  c2.addItemListener(this);
  add(c1);   add(c2);
  add(txt1); add(txt2);
}

public void itemStateChanged(ItemEvent e){
   Object source = e.getItemSelectable();
   if (source==c1)
       txt1.setText("Sono cambiate le mele");
   else
       txt1.setText("Sono cambiate le pere");
   // ora si controlla lo stato globale
   String frase = (c1.isSelected() ? "Mele " : "")
             + (c2.isSelected() ? "Pere" : "");
   txt2.setText(frase);
   }
}

