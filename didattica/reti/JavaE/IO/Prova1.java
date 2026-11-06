
import java.io.*;


public class Prova1 {

  static List makeList() {
	List l = new List();
	l = l.cons(new Integer(5));
	l = l.cons(new String("ciao"));
	return l;
  }

  public static void main(String args[]){
	FileOutputStream f = null;
	try { f = new FileOutputStream("Prova.dat"); }
	catch(IOException e){ System.exit(1); }

	ObjectOutputStream os = null;
	List l = makeList();
	System.out.print("Scrittura su file...");
	try { 	os = new ObjectOutputStream(f);
			os.writeObject(l);	os.flush(); 
			os.close();
	}
	catch (IOException e){ System.exit(2); }
	System.out.println(" ok.");	

	System.out.println("Rilettura da file:");
	FileInputStream  fin = null;
	ObjectInputStream is = null;
	try {
		fin = new FileInputStream("Prova.dat");
		is = new ObjectInputStream(fin);
	}
	catch(IOException e){ System.exit(3); }

	List x=null;
	try { x = (List)(is.readObject()); 
		  is.close();
	}
	catch (IOException e){ System.exit(4); }
	catch (ClassNotFoundException e){
		System.exit(5);
	}

	List xx=x;
	while (xx!=null){
	  System.out.println(xx.head());
	  xx = xx.tail();
	}
  }
}
