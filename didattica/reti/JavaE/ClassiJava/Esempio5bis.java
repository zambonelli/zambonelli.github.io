/**
 * Secondo esempio d'uso di array Java
 @author Enrico Denti
 @version 1.0, 5/4/98 */

class Esempio5bis {

public static void main(String args[]){

String v1[]; // RIFERIMENTO al futuro vettore
// si pu• anche scrivere  String[] v1;

v1 = new String[2];
// creazione vettore di due (rif. a) String
// NB: le due String per• ancora non esistono!

v1[0] = "Ciao mondo";  // una String costante
v1[1] = new String(v1[0]);
// una String creata din. uguale alla prima
 }
}

