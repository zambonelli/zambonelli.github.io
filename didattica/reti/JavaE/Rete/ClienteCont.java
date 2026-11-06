import java.net.*;  import java.io.*;
public class ClienteCont {
 public static void main(String args[]){
	Socket s = null;
	try {
	 s = new Socket("localhost",11111);
	 BufferedReader r = 
new BufferedReader(	new           InputStreamReader(s.getInputStream()));
	 String line;
 
	 while((line=r.readLine())!=null ){
	  System.out.println(line);
	  if (line.equals("Stop")) break;
	 }
	 r.close(); s.close();
	} catch (UnknownHostException e){
	   System.err.println("Host unknown");
	} catch (Exception e){
	   System.err.println(e);
	}  } }

