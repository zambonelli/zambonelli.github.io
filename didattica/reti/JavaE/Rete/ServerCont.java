import java.net.*;  import java.io.*;
public class ServerCont {
 public static void main(String args[]){
	Socket cs = null; ServerSocket ss = null;
	int numero = 1;
	try {
	 ss = new ServerSocket(11111);
	 while (true) { // ciclo infinito del server
		cs = ss.accept();
         System.out.println("Cliente Connesso gli mando" + numero);
 
	 PrintWriter pw =	new
    PrintWriter(cs.getOutputStream(),true);
// il parametro true significa 
// autoflush attivo
	 pw.println("Nuovo numero: " + numero);
	 numero++; pw.println("Stop"); 
	 pw.close(); cs.close();
   } // end while
  } catch (UnknownHostException e){
	   System.err.println("Host unknown"); }
    catch (Exception e){ System.err.println(e); }
 } }

