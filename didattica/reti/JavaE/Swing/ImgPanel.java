import java.awt.*;
import javax.swing.*;


public class ImgPanel extends JPanel {
Image img1;
public ImgPanel(){
Toolkit tk = Toolkit.getDefaultToolkit();
img1 = tk.getImage("moon.gif");
MediaTracker mt = new MediaTracker(this);
mt.addImage(img1, 1);
// aggiunta di eventuali altre immagini
try { mt.waitForAll(); }
catch (InterruptedException e){}
}

public void paintComponent(Graphics g){
        super.paintComponent(g);
                g.drawImage(img1, 30, 30, null);
                /* Immagine (img1), posizione nel pannello (30,30) e un oggetto
                (null, cioä nessuno) a cui notificare l'avvenuto caricamento */
                }


                }

