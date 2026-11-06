class Esempio6 {

public static void main(String args[]){

int x = 35;   // tipo primitivo

Integer ix = new Integer(x);
// conversione int to Integer per costruzione

System.out.println("ix = " + ix);
// conversione implicita Integer to String

x = ix.intValue()*4;
// conversione esplicita Integer to int

System.out.println("x = " + x);
// conversione implicita int © String
}
}

