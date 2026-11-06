import java.io.*;
public class Es2 {
  public static void main(String args[]){
	FileWriter fout = null;
	try { fout = new FileWriter("Prova.txt"); }
	catch(IOException e){
	  System.out.println("Apertura file fallita");
	  System.exit(1);
	}
	float f1 = 3.1415F;	char c1 = 'E';
	boolean b1 = true;		double d1 = 1.4142;
	try {
	  String buffer = null;
	  buffer = Float.toString(f1);
	  fout.write(buffer,0,buffer.length());
	  buffer = new Boolean(b1).toString(); // *
	  fout.write(buffer,0,buffer.length());
	  buffer = Double.toString(d1);
	  fout.write(buffer,0,buffer.length());
	  fout.write(c1); // singolo carattere
	  buffer = Integer.toString(12);
	  fout.write(buffer,0,buffer.length());
	  fout.close();
	}
	catch (IOException e){
	  System.out.println("Errore di scrittura");
	  System.exit(2);	}


System.out.println("Rilettura da file:");
	FileReader fin = null;
	try {
		fin = new FileReader("Prova.txt");
	}
	catch(FileNotFoundException e){
	  System.out.println("File non trovato");
	  System.exit(3);
	}
	// ----- ciclo di lettura ----
	try {
	  while(fin.ready()){
		char ch = (char)fin.read();
		System.out.print(ch);
	  }
	  System.out.println("");
	}
	catch (IOException e){
	  System.out.println("Errore di input");
	  System.exit(4);
	}
  } // NB: stampa 3.1415true1.4142E12
}
