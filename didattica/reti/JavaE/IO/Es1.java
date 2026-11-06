import java.io.*;
public class Es1 {
  public static void main(String args[]){
	FileOutputStream f = null;
	try {
		f = new FileOutputStream("Prova.dat");
	}
	catch(IOException e){
	  System.out.println("Apertura file fallita");
	  System.exit(1);
	}
	DataOutputStream os = new DataOutputStream(f);
	System.out.print("Scrittura su file...");
	float f1 = 3.1415F;	char c1 = 'E';
	boolean b1 = true;		double d1 = 1.4142;
	try {
	  os.writeFloat(f1);
	  os.writeBoolean(b1);
	  os.writeDouble(d1);
	  os.writeChar(c1);
	  os.writeInt(12);
	  os.close();
	}
	catch (IOException e){
	  System.out.println("Scrittura fallita");
	  System.exit(2);
	}
	System.out.println(" done.");

	System.out.println("Rilettura da file:");
	FileInputStream  fin = null;
	try {
		fin = new FileInputStream("Prova.dat");
	}
	catch(FileNotFoundException e){
	  System.out.println("File non trovato");
	  System.exit(3);
	}
	DataInputStream is = new DataInputStream(fin);
	try {
	  float f2;		  char  c2;
	  boolean b2;	  double  d2;
	  int i2;
	  f2 = is.readFloat();
	  b2 = is.readBoolean();
	  d2 = is.readDouble();
	  c2 = is.readChar();
	  i2 = is.readInt();
	  is.close();
	  System.out.println(f2 + ", " + b2 + ", " 
					+ d2 + ", " + c2 + ", " + i2);
	}
	catch (IOException e){
	  System.out.println("Errore di input");
	  System.exit(4);
	}
  }

}

