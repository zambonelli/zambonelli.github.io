import java.io.*;
public class Es3 {
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
	  buffer = Float.toString(f1)+ " ";
	  fout.write(buffer,0,buffer.length());
	  buffer = new Boolean(b1).toString() + " "; 
	  fout.write(buffer,0,buffer.length());
	  fout.write(c1); // singolo carattere 
	  fout.write(' '); // AGGIUNGO LO SPAZIO 
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
		String s = readField(fin);
		System.out.println(s);
	  }
	}
	catch (IOException e){
	  System.out.println("Errore di input");
	  System.exit(4);
	}

}


static public String readField(Reader in){
	StringBuffer buf = new StringBuffer();
	boolean nospace = true;
	try {
	  while(in.ready() && nospace){
		char ch =(char)in.read();
		nospace = (ch!=' ');
		if (nospace) buf.append(ch);
	  }
	}
	catch (IOException e){
	  System.out.println("Errore di input");
	  System.exit(4);
	}
	return buf.toString();
 }


}
