/** File Esempio2.java
  * Prima applicazione che istanzia nuovi oggetti
    @author Enrico Denti
      @version 1.0, 5/4/98 */

class Counter {
 private int val;
 public void reset() { val = 0; }
 public void inc()   { val++; }
 public void dec()   { val--; }
 public int  rd()    { return val; }
}


public class Esempio2 { // contiene solo il main

public static void main(String args[]){
  Counter c1, c2;
    c1 = new Counter(); c2 = new Counter();
    c1.reset(); c2.reset();
    c1.inc(); c1.inc(); c2.inc();
    System.out.println("c1 vale " + c1.rd());
    System.out.println("c2 vale " + c2.rd());
  }

}
