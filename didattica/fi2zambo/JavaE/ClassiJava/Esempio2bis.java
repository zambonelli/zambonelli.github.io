/** FILE Esempio2bis.java
  * Prima applicazione che istanzia nuovi oggetti
    @author Enrico Denti
      @version 1.0, 8/3/99  */


public class Esempio2bis {

public static void main(String args[]){
 Counter c1, c2;
   c1 = new Counter(); c2 = new Counter(5);
   c1.inc(); c1.inc(); c2.inc();
   System.out.println("c1 vale " + c1.rd());
   System.out.println("c2 vale " + c2.rd());
   }
}

