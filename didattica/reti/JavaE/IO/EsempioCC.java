public class EsempioCC {
  public static void main(String args[]){
    Counter c = new Counter();
        ThreadCC t1 = new ThreadCC(c);
         ThreadCC t2 = new ThreadCC(c);
          t1.start();
           t2.start();
         
              }}

