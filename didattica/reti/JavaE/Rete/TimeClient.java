import java.net.*;
import java.io.*;
public class TimeClient {
 public static void main(String args[]){
	Socket s = null;
 try { s = new Socket("localhost",7777);
		InputStream is = s.getInputStream();
	InputStreamReader ir =
 	 new InputStreamReader(is);
	BufferedReader r =
 				  new BufferedReader(ir);

		String line = r.readLine();
		System.out.println(line);
		s.close();
		} catch (UnknownHostException e){
		   System.err.println("Host unknown");
		} catch (Exception e){
		   System.err.println(e);
		}
  }
}
