/**
* verifica il concetto di uguaglianza fra oggetti
@author Enrico Denti
*/



class Esempio4 {

public static void main(String args[]){
 Point p1 = new Point(100,10), p2=p1;
   System.out.println("p1==p2? " + (p1==p2));
   System.out.println("p1.equals(p2)? " +
   p1.equals(p2));
   p2 = (Point)p1.clone();  p1.x = 400;
   System.out.println("p1==p2? " + (p1==p2));
   System.out.println("p1.equals(p2)? " + p1.equals(p2));
   }
}

