import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class Es11Panel extends JPanel implements ActionListener {
JTextField txt1, txt2;
 public Es11Panel(){
    super();
    txt1=new JTextField("Scrivere qui il testo", 25);
    txt2 = new JTextField(25);
    txt2.setEditable(false);
    txt1.addActionListener(this);
    // gli eventi di txt1 vengono ascoltati da this
    add(txt1);
    add(txt2);
}

public void actionPerformed(ActionEvent e){
      txt2.setText( txt1.getText() );
       }

}


