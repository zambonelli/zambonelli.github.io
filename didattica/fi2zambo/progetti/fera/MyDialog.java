

import java.awt.*;
import java.awt.event.*;
import java.awt.Component;

public class MyDialog extends Dialog
  implements ActionListener
{

  public MyDialog(Frame parentWin,String text)
  {
    super(parentWin,"Attenzione",true);
    this.setModal(true);
    this.setResizable(false);
    this.setLayout(new GridLayout(2,1,10,10));
    Label msg=new Label(text,Label.CENTER);
    this.add(msg);

    Button b=new Button("OK");
    b.addActionListener(this);
    this.add(b);
    this.setSize(text.length()*10,100);

    //faccio comparire la fin. di dialogo al centro della parent
    this.setLocation(parentWin.getLocation().x+Math.abs(parentWin.getSize().width-this.getSize().width)/2,
                     parentWin.getLocation().y+Math.abs(parentWin.getSize().height-this.getSize().height)/2);
    this.show();
  }

  public void actionPerformed(ActionEvent e){
    if(e.getSource() instanceof Button)
      this.removeAll();
      hide();
  }
}
