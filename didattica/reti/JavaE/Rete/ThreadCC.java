public class ThreadCC extends Thread {
Counter c;
int i;
  public ThreadCC(Counter cc)
   { c = cc; }

     public void run(){
      for( i=1; i<=10; i++)
       { System.out.println("i vale: " + i);
         c.inc();
             System.out.println("Count vale: " + c.rd());}
               }}

