

import java.awt.*;
import java.awt.event.*;

class Caselle extends Canvas
  implements MouseListener {
  private int xPos;
  private int yPos;
  private boolean atBoundYesNo;
  private boolean pedinaYesNo;
  private boolean isWhiteBlack;
  private boolean isPedinaDama;
  private DamaApplet theApplet;
  private Color colorCas;
  private int imageID;

  public Caselle(int x, int y, DamaApplet theAplt) {
    this.theApplet=theAplt;

    //definisco il colore della casella
    if((x+y)%2==0)
      this.colorCas=Color.yellow;
    else
      this.colorCas=Color.black;
    this.addMouseListener(this); //aggiunto l'ascoltatore per la casella

    //pongo le pedine sulle prime tre colonne della scacchiera
    if(y==0 || y==1 || y==2)    {
      if(this.colorCas==Color.black){//le pedine vanno solo sulle caselle nere
        this.imageID=0; //pedina bianca
        this.pedinaYesNo=true;
        this.isPedinaDama=true;
        this.isWhiteBlack=true;
      }
      else{
        this.imageID=-1; //non c'è immagine
        this.pedinaYesNo=false;
      }
    }
    //pongo le pedine sulle ultime tre colonen della scacchiera
    else if(y==this.theApplet.dimOrizzVert-3 || y==this.theApplet.dimOrizzVert-2 || y==this.theApplet.dimOrizzVert-1)         {
          if(this.colorCas==Color.black){//le pedine vanno solo sulle caselle nere
            this.imageID=1; //pedina bianca
            this.pedinaYesNo=true;
            this.isPedinaDama=true;
            this.isWhiteBlack=false;
          }
          else{
            this.imageID=-1;
            this.pedinaYesNo=false;
          }
        }
        else         {
          this.imageID=-1; //nessuna pedina
          this.pedinaYesNo=false;
          }
    this.xPos=x;
    this.yPos=y;

    if(y==0 || y==this.theApplet.dimOrizzVert-1)
    //sono su una casella di fine scacchiera
      this.atBoundYesNo=true;
    else
      this.atBoundYesNo=false;
  }

  public void paint(Graphics g)  {
    this.setBackground(this.colorCas);
    if(this.imageID!=-1)
     // c'è 1 pedina
      g.drawImage(this.theApplet.imgs[this.imageID],8,6,this);
  }

  // metodo che gestisce l'annulamento di una mossa da parte del player
  public void PedinaDontGoAway(){
    if(this.isWhiteBlack==true){
      if(this.isPedinaDama==true)
      //pedina bianca
        this.imageID=0;
      else
      //dama bianca
        this.imageID=2;
    }
    else{
      if(this.isPedinaDama==true)
      //pedina nera
        this.imageID=1;
      else
      //dama nera
        this.imageID=3;
    }
    repaint();
  }

  //metodo che gestisce il cambiamento di stato di una casella:
  //da "con pedina" a "senza pedina"
  public void PedinaGoOut()  {
    this.imageID=-1;
    this.pedinaYesNo=false;
    repaint();
  }

  //metodo che gestisce il cambiamento di stato di una casella:
  //da "senza pedina" a "con pedina"
  public void PedinaGoIn()  {
    this.pedinaYesNo=true;
    repaint();
  }

  //metodo che gestisce i click sulle caselle distinguendo tutti i vari casi:
  //1) sulla casella non c'è pedina e il player non ne stà spostando una
  //2) sulla casella non c'è pedina e il player ne stà spostando una
  //3) sulla casella c'è una pedina e il player non ne stà spostando una
  //4) sulla casella c'è una pedina e il player ne stà spostando una
  public void mouseClicked(MouseEvent e)  {
    if(this.pedinaYesNo==false && this.theApplet.mossa.playerMoving==false) {
      //sulla casella non c'è pedina e il player non ne stà spostando una
      MyDialog dl=new MyDialog(theApplet.win,"Devi cliccare su un pedina");
      return;
    }
    if(this.pedinaYesNo==false && this.theApplet.mossa.playerMoving==true)    {
      //sulla casella non c'è pedina e il player ne stà spostando una
      this.theApplet.mossa.end=this;
      this.theApplet.mossa.CheckMove();
      return;
    }
    if(this.pedinaYesNo==true && this.theApplet.mossa.playerMoving==false)    {
      //sulla casella c'è una pedina e il player non ne stà spostando una
      this.theApplet.mossa.playerMoving=true;
      this.theApplet.mossa.start=this;
      if(this.isPedinaDama==true)
      //sto spostando una pedina
        this.imageID=4;
      else
      //sto spostando una dama
        this.imageID=5;
      repaint();
      return;
    }
    if(this.pedinaYesNo==true && this.theApplet.mossa.playerMoving==true)    {
      //sulla casella c'è una pedina e il player ne stà spostando una
      if(this.theApplet.mossa.start==this){
      //ho ricliccato sulla casela di partenza => voglio annullare la mossa
        this.theApplet.mossa.start.PedinaDontGoAway();
        this.theApplet.mossa.playerMoving=false;
        MyDialog dl=new MyDialog(theApplet.win,"Mossa annullata");
        }
      else{
      //il player ha cliccato su una casella occupata
        MyDialog dl=new MyDialog(theApplet.win,"Devi cliccare su una casella vuota");
        }
      return;
    }
  }

  // metodi per la gestione in lettura e scrittura del membro isWhiteBlack
  public boolean IsWhiteBlack()  {
    return this.isWhiteBlack;
  }

  public void SetIsWhiteBlack(boolean newState)  {
    this.isWhiteBlack=newState;
  }

 // metodo per la rilevazione della cordinata x o y
  public int WhatsXorY(boolean xOrY){
    if(xOrY==true)
      return this.xPos;
    else
      return this.yPos;
  }

  // metodo per verificare se la casella è una casella di bordo dx e sx
  // necessario per tramutare una pedina in dama
  public boolean IsAtBoundYesNo(){
    return this.atBoundYesNo;
  }

  // metodo per la lettura del membro pedinaYesNo
  public boolean PedinaYesNo(){
    return this.pedinaYesNo;
  }

  // metodi per la gestione in lettura e scrittura del membro isPedinaDama
  public boolean IsPedinaDama()  {
    return this.isPedinaDama;
  }

  public void SetIsPedinaDama(boolean newState)  {
    this.isPedinaDama=newState;
  }

  //metodo per la scrittura sul membro imageID
  public void SetImageID(int newState)  {
    this.imageID=newState;
  }

  public void mousePressed(MouseEvent e)  {   }

  public void mouseReleased(MouseEvent e)  {  }

  public void mouseEntered(MouseEvent e)  {  }

  public void mouseExited(MouseEvent e)  {  }

  }
