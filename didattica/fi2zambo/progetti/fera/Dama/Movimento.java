

import java.lang.Math;

public class Movimento{
  public boolean playerMoving;
  public Caselle start;
  public Caselle end;

  private DamaApplet theApplet;
  private int blackNumber;
  private int whiteNumber;


  public Movimento(DamaApplet theAplt)  {
    this.playerMoving=false;
    this.theApplet=theAplt;
    this.whiteNumber=this.blackNumber=12;
  }

  // metodo genrico per il controllo della validità di una mossa effettuata

  public void CheckMove()  {
    //devo controllare la validità della mossa
    if(this.IsMoveOKYesNo()==true){
    //la mossa è lecita
      this.MakeItDama();
      this.MakeMove();
      }
    else{
    // la mossa non è lecita
      MyDialog dl=new MyDialog(this.theApplet.win,"La mossa non è lecita");
      }
  }

  //metodo per un controllo più specifico della validità
  //della mossa secondo le regole del gioco della dama
  private boolean IsMoveOKYesNo(){
    int gap;

    if(this.start.IsWhiteBlack()==true)
    //pedina bianca, mi muovo da sx vs dx
      gap=1;
    else
    //pedina nera, mi muovo da dx vs sx
      gap=-1;

    if((this.end.WhatsXorY(true)==this.start.WhatsXorY(true)+1) ||
       (this.end.WhatsXorY(true)==this.start.WhatsXorY(true)-1)){
    //voglio muovermi in alto o in basso di una casella
      if(this.start.IsPedinaDama()==false){
      //sto muovendo una dama, può muoversi anche all'indietro
        if(this.end.WhatsXorY(false)==this.start.WhatsXorY(false)-gap*1)
        // voglio muovere la dama in diagonale all'indietro di una casella
          return true;
        }
      if(this.end.WhatsXorY(false)==this.start.WhatsXorY(false)+gap*1)
      // voglio muovere la pedina in diagonale in avanti di una casella
        return true;
      else
        return false;
    }
    else{
    //può darsi che voglia mangiare qualcosa
      if(this.EatSomeThingYesNo()==true)
        return true;
      else
        return false;
      }
  }

  //metodo per effettuare una mangiata di pedina o dama, compatibilmente
  // alle regole del gioco
  private boolean EatSomeThingYesNo(){
    int gapX, gapY;
    //devo chiamare la PedinaGoOut per la pedina mangiata
    if((Math.abs(this.end.WhatsXorY(true)-this.start.WhatsXorY(true))==2) &&
        (Math.abs(this.end.WhatsXorY(false)-this.start.WhatsXorY(false))==2)){
    // mi sono mosso in diagonale
      if(this.end.WhatsXorY(true)>this.start.WhatsXorY(true))
      //mi sono mosso verso il basso
        gapX=1;
      else
      //mi sono mosso verso l'alto
        gapX=-1;
      if(this.end.WhatsXorY(false)>this.start.WhatsXorY(false))
      // mi sono mosso verso DX
        gapY=1;
      else
      //mi sono mosso verso SX
        gapY=-1;
        if(this.theApplet.GetCasella(this.start.WhatsXorY(true)+gapX*1,this.start.WhatsXorY(false)+gapY*1)
            .PedinaYesNo()==false)
        //ho fatto una mossa non valida
          return false;
        else{
        //sto cercando di mangiare una pedina
        //controllo se lo posso fare visto che pedina non mangia dama
          if(this.theApplet.GetCasella(this.start.WhatsXorY(true)+gapX*1,this.start.WhatsXorY(false)+gapY*1)
              .IsWhiteBlack()==this.start.IsWhiteBlack())
          //sto cercando di mangiare una pedina del mio colore
            return false;
          else{
          //voglio mangiare una pedina del mio avversario
            if(this.theApplet.GetCasella(this.start.WhatsXorY(true)+gapX*1,this.start.WhatsXorY(false)+gapY*1)
              .IsPedinaDama()!=this.start.IsPedinaDama()){
            //voglio mangiare qualcosa di diverso da me
              if(this.start.IsPedinaDama()==true)
              //stavo cercando di mangiare una dama con una mia pedina
                return false;
            }
            //se sono qui ho 2 possibilità:
            //1) sono una dama e voglio mangiare qualcosa
            //2) sono una pedina e mangio un altra pedina
            this.theApplet.GetCasella(this.start.WhatsXorY(true)+gapX*1,this.start.WhatsXorY(false)+gapY*1)
                .PedinaGoOut();
            if(this.start.IsWhiteBlack()==true)
            //sono bianco e ho mangiato nero
              this.blackNumber--;
            else
            //sono nero e ho mangiato bianco
              this.whiteNumber--;
          }
        }
    }
    else
    //non voglio mangiare nulla
      return false;

  //giungo in a questo punto solo se ho potuto mangiare qualcosa

  //controllo se qualcuno non abbia vinto
  if(this.blackNumber==0)
  //ha vinto il bianco
    this.theApplet.TheWinner("!! Ha vinto il giocatore di SX !!");
  if(this.whiteNumber==0)
  //ha vinto il nero
    this.theApplet.TheWinner("!! Ha vinto il giocatore di DX !!");
  return true;
  }

  // metodo per tramutare una pedina in dama
  private void MakeItDama(){
    //verifico se posso trasformare la pedina in una dama
    if(this.start.IsPedinaDama()==true && this.end.IsAtBoundYesNo()==true){
    // la pedina è una pedina e la sto posizionando su una casella di bordo
      if((this.start.IsWhiteBlack()==true && this.end.WhatsXorY(false)==this.theApplet.dimOrizzVert-1) ||
          //è una pedina bianca e si trova dall'altra parte da dove è partita
          (this.start.IsWhiteBlack()==false && this.end.WhatsXorY(false)==0))
          //è una pedina nera e si trova dall'altra parte da dove è partita

          //per semplificare il passaggio da pedina a dama faccio finta
          //che la pedina inizialmente fosse già una dama
          this.start.SetIsPedinaDama(false);
    }
  }

 // metodo che praticamente realizza il movimento, cioè modifico gli attributi
 // specifici nella casella di arrivo secondo i valori degli stessi attributi
 // della casella di partenza
  private void MakeMove()  {
    if(this.start.IsWhiteBlack()==true)      {
    //era bianca
      this.end.SetIsWhiteBlack(true);
      if(this.start.IsPedinaDama()==true)        {
        //era una pedina bianca
        this.end.SetImageID(0);
        this.end.SetIsPedinaDama(true);
        }
      else{
        //era una dama bianca
        this.end.SetImageID(2);
        this.end.SetIsPedinaDama(false);
        }
      }
    else {
      //era nera
      this.end.SetIsWhiteBlack(false);
      if(this.start.IsPedinaDama()==true){
        //era una pedina nera
        this.end.SetImageID(1);
        this.end.SetIsPedinaDama(true);
        }
      else{ //era una dama nera
        this.end.SetImageID(3);
        this.end.SetIsPedinaDama(false);
        }
    }
    this.end.PedinaGoIn();
    this.start.PedinaGoOut();
    this.playerMoving=false;
  }

}