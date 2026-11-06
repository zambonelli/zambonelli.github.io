import java.net.*;  import java.io.*;

public class ClientCC {
 public static void main(String args[]){
	Counter c = new Counter();
   Socket s = null;
   c.inc();
System.out.println("Valore Contatore: " + c.rd());
	try {
	 s = new Socket("localhost",11112);
	 ObjectInputStream is =    new
   ObjectInputStream(s.getInputStream());
	 ObjectOutputStream os =  new
   ObjectOutputStream(s.getOutputStream());
	
	os.writeObject(c);
  c = (Counter)is.readObject();
System.out.println("Valore Contatore: " + c.rd());
	} 
catch (Exception e){System.err.println(e);}
 } 
}
