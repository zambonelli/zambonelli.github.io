import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class Applet3Listener implements ActionListener {
JTextArea area; JTextField riga;

Applet3Listener(JTextArea ta, JTextField tf){
    area = ta; riga = tf;
     }

public void actionPerformed(ActionEvent e){
    String azione = e.getActionCommand();
    String testoDaInserire;
    if (azione.equals("Elimina")) testoDaInserire = "";
    else testoDaInserire = riga.getText();
    int start = area.getSelectionStart();
    int end   = area.getSelectionEnd();
    area.replaceRange(testoDaInserire,start,end);
    area.select(start,start);
    }
}

