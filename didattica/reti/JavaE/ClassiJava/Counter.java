/** FILE Counter.java
  * Questa classe definisce il concetto di
 contatore avanti/indietro.
 @author Enrico Denti
 @version 1.0, 8/3/99  */
   public class Counter {
   private int val;
   public Counter()    { val=1; }  // default
   public Counter(int x) { val=x; }
   public void reset() { val = 0; }
   public void inc()   { val++; }
   public void dec()   { val--; }
   public int  rd()    { return val; }
}

