import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.*;


public class CalcButton extends JButton {

CalcButton(String n) {
   super(n);
   setFont(new Font("Courier",Font.BOLD,20));
   // estendiamo Jbutton per personalizzare il font
   }

}

