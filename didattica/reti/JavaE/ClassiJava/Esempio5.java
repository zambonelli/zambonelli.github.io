 /**
  * Primo esempio d'uso di array in Java
   @author Enrico Denti
    @version 1.0, 5/4/98 */

class Esempio5 {

public static void main(String args[]){

  int[] v1 = {8,12,3,4};   // vettore di 4 int
  int[] v2; // riferimento a un vettore di int

  v2 = new int[5]; // creazione vett. di 5 int
  // (crea 5 celle int, inizializzate a 0)

  for(int i=1; i<=v2.length; i++) v2[i-1] = i*i;
        for(int i=0; i<v1.length; i++)

  System.out.print(v1[i] + '\t');
  System.out.println("");
  for(int i=0; i<v2.length; i++)
        System.out.print(v2[i] + '\t');
  }
}

