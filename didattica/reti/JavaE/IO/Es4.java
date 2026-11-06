import java.io.*;

public class Es4 {
  public static void main(String args[]){
	FileReader fin = null;

	DataReader dr = new DataReader(fin);
   try {
	  float f2 = dr.readFloat();
	  boolean b2 = dr.readBoolean();
	  double d2 = dr.readDouble();
	  char c2 = dr.readChar();	  
	  int i2 = dr.readInt();
	  dr.close();
	  System.out.println(f2 + ", " + b2 + ", " 
					+ d2 + ", " + c2 + ", " + i2);
	}
	catch (IOException e){
	  System.out.println("Errore di input");
	  System.exit(4);
	}
	// ------- da console -------
	DataReader consoleInput = new DataReader(
				new InputStreamReader(System.in));
	System.out.println("Inserire nell'ordine un"
		+ " float, un boolean, un double, un char"
		+ " e un int, separati da UNO spazio: ");
	try {
	  float f2 = consoleInput.readFloat();
   
	}
 catch (IOException e){ }
  }
}


