import java.net.*;  import java.io.*;

public class ServerCC {
 public static void main(String args[]){
	Socket cs = null; ServerSocket ss = null;
  Counter c;
	try {
	 ss = new ServerSocket(11112);
	 while (true) { // ciclo infinito
	  cs = ss.accept();
	  ObjectOutputStream os =	new
   ObjectOutputStream(cs.getOutputStream());
ObjectInputStream is =	new
    ObjectInputStream(cs.getInputStream());
   c = (Counter)is.readObject();
   System.out.println("Ricevuto contatore con valore: " + c.rd());
    c.inc();
      os.writeObject(c);
       os.close(); is.close(); cs.close();
   } // end while
  } catch (UnknownHostException e){
	  System.err.println("Host unknown"); }
   catch (Exception e){ System.err.println(e); }
 } }
