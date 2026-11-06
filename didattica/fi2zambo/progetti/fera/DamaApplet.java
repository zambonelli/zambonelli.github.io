
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;

public class DamaApplet extends Applet {
  //elementi dell'interfaccia

  private Caselle scacchiera[][];
  public final int dimOrizzVert=8;
  public Image[] imgs;
  public Movimento mossa;

  public FlowLayout appletLayout = new FlowLayout();
  public Button bottonStart = new Button();

  public Frame win = new Frame();
  public GridLayout gameLayout = new GridLayout();
  public MenuBar menuBar = new MenuBar();
  public Menu menuGame = new Menu();
  public MenuItem menuGameItemNew = new MenuItem();
  public MenuItem menuGameItemEnd = new MenuItem();
  public MenuItem menuGameItemExit = new MenuItem();
  public Menu menuHelp = new Menu();
  public MenuItem menuHelpItemAbout = new MenuItem();

  //Costruisco l'applet
  public DamaApplet() {
            try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  //Inizializza l'applet
  public void init() {

    scacchiera=new Caselle[dimOrizzVert][dimOrizzVert];
    imgs=new Image[6]; // 1) pedina bianco
                       // 2) pedina nera
                       // 3) dama bianca
                       // 4) dama nera
                       // 5) pedina tmp
                       // 6) dama tmp
    //carico le varie immagini
    imgs[0] =getImage(getCodeBase(),"images/pedina1.gif");
    imgs[1] =getImage(getCodeBase(),"images/pedina2.gif");
    imgs[2] =getImage(getCodeBase(),"images/pedina3.gif");
    imgs[3] =getImage(getCodeBase(),"images/pedina4.gif");
    imgs[4] =getImage(getCodeBase(),"images/pedina5.gif");
    imgs[5] =getImage(getCodeBase(),"images/pedina6.gif");

    mossa=new Movimento(this);
  }

  public void TheWinner(String theWinner){
    MyDialog dl=new MyDialog(win,theWinner);
    this.win.removeAll();
  }

  public Caselle GetCasella(int x, int y){
    return this.scacchiera[x][y];
  }

  private void jbInit() throws Exception
  {
    //definisco il layout dell'applet
    this.setLayout(appletLayout);
    this.setEnabled(true);

    bottonStart.setActionCommand("bottonStart");
    bottonStart.setLabel("Start");
    bottonStart.addActionListener(new java.awt.event.ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        bottonStart_actionPerformed(e);
      }
    });
    this.add(bottonStart, null);

    //costruisco il menu
    menuGame.setLabel("Game");
    menuGame.setShortcut(new MenuShortcut(71));
    menuGameItemNew.setLabel("New Game ");
    menuGameItemNew.setShortcut(new MenuShortcut(78));
    menuGameItemNew.addActionListener(new java.awt.event.ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        menuGameItemNew_actionPerformed(e);
      }
    });
    menuGameItemEnd.setLabel("End Game");
    menuGameItemEnd.setShortcut(new MenuShortcut(69));
    menuGameItemEnd.addActionListener(new java.awt.event.ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        menuGameItemEnd_actionPerformed(e);
      }
    });
    menuGameItemExit.setLabel("Exit");
    menuGameItemExit.setShortcut(new MenuShortcut(88));
    menuGameItemExit.addActionListener(new java.awt.event.ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        menuGameItemExit_actionPerformed(e);
      }
    });
    menuGame.add(menuGameItemNew);
    menuGame.add(menuGameItemEnd);
    menuGame.addSeparator();
    menuGame.add(menuGameItemExit);
    menuBar.add(menuGame);

    menuHelpItemAbout.setLabel("About");
    menuHelpItemAbout.setShortcut(new MenuShortcut(65));
    menuHelpItemAbout.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        menuHelpItemAbout_actionPerformed(e);
      }
    });
    menuHelp.setLabel("Help");
    menuHelp.setShortcut(new MenuShortcut(72));
    menuHelp.add(menuHelpItemAbout);
    menuBar.add(menuHelp);

    //definisco il layout della finestra
    gameLayout.setColumns(8);
    gameLayout.setRows(8);
    //definisco la window
    win.setEnabled(true);
    win.setVisible(false);
    win.setResizable(false);
    win.setLayout(gameLayout);
    win.setMenuBar(menuBar);
    win.setTitle("Dama");
    win.setSize(45*this.dimOrizzVert,45*this.dimOrizzVert);
    win.addWindowListener(new java.awt.event.WindowAdapter()
    {

      public void windowClosing(WindowEvent e)
      {
        win_windowClosing(e);
      }
    });

  }

  void win_windowClosing(WindowEvent e)
  {
    this.win.removeAll();
    this.win.hide();
  }

  void menuGameItemNew_actionPerformed(ActionEvent e)
  {
    int x,y;
    this.win.removeAll();

    //definisco la scacchiera
    for(x=0,y=0;x<dimOrizzVert;x++)    {
      for(;y<dimOrizzVert;y++)      {
        scacchiera[x][y] = new Caselle(x,y,this);
        win.add(scacchiera[x][y]);
        }
        y=0;
      }
    this.win.show();
  }

  void menuGameItemExit_actionPerformed(ActionEvent e)
  {
    win.removeAll();
    this.win.hide();
    this.stop();
  }

  void menuGameItemEnd_actionPerformed(ActionEvent e)
  {
    win.removeAll();
    win.show();
  }

  void bottonStart_actionPerformed(ActionEvent e)  {
    win.setVisible(true);
    win.show();
  }

  void menuHelpItemAbout_actionPerformed(ActionEvent e) {
    MyDialog dl=new MyDialog(this.win,"Realizzato da Francesco Fera");
  }

}
