class Esempio7 {

  static int[] creaIntervallo(int inf, int sup){
  // restituisce un (rif. a) un array di int
  int[] v = new int[sup-inf+1];
  for (int i=0; i<v.length; i++) v[i]=inf++;
  return v;
  }

  static void print(int v[]){
     for(int i=0; i<v.length; i++)
        System.out.println(v[i]);
  }

  static void increment(int v[]){
       for(int i=0; i<v.length; i++) v[i]++;
  }

  public static void main(String args[]){

   int[] v1 = creaIntervallo(3,8);
   print(v1);   // Esempio7.print(v1);
   increment(v1);  // Esempio7.increment(v1);
   print(v1);   // Esempio7.print(v1);
  }
}
