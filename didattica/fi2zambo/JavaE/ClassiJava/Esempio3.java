/**
* verifica il concetto di Riferimento a oggetti
@author Enrico Denti
@version 1.0, 5/4/98
*/

class Point {
 public int x; public int y;
 public Point(int x, int y)
             { this.x=x; this.y=y;}
 }

class Esempio3 { // contiene solo il main

public static void main(String args[]){
 Point p1 = new Point(100,10), p2 = p1;
   System.out.println("p1: " + p1.x + "," + p1.y);
   System.out.println("p2: " + p2.x + "," + p2.y);
   p1.x = 400;
   System.out.println("p1: " + p1.x + "," + p1.y);
   System.out.println("p2: " + p2.x + "," + p2.y);
   }
}

