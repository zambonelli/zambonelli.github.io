import java.net.*;
import java.io.*;
public class TimeServer {
 public static void main(String args[]){
	ServerSocket ss = null;
	try {
	 ss = new ServerSocket(7777);
	 while (true) {
		Socket clientSock = ss.accept();
  System.out.println("Un client si e appena connesso");
		OutputStream os =
		 clientSock.getOutputStream();
	
  PrintStream outp = new PrintStream(os);
	  outp.println(new java.util.Date());
	  clientSock.close();
   }
  } catch (UnknownHostException e){
		System.err.println("Host unknown");
	} catch (Exception e){
	   System.err.println(e);
	}
 }
}
