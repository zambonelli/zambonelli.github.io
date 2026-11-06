 /** File Esempio1.java
  * applicazione da linea di comando
   * stampa gli argomenti passati al programma
    @author Enrico Denti
     @version 1.0, 9/11/97
      */

public class Esempio1 {

public static void main(String args[]){
    if (args.length == 0)
        System.out.println("Occorrono argomenti");
    else
        for(int i=0; i<args.length; i++)
           System.out.println("arg" + (i+1) +  ": " + args[i]);
    }
}

