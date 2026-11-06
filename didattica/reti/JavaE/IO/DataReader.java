
import java.io.*;

class DataReader extends Reader {
  InputStreamReader in;
 
 public DataReader(InputStreamReader in) {
		 this.in=in;
  }
  public void close() throws IOException {
		in.close();   // DELEGAZIONE
  }
  public int read(char b[], int off, int len) 
	throws IOException { 
		return in.read(b,off,len); // DELEGAZIONE
  }

  public String readString() throws IOException {
	StringBuffer buf = new StringBuffer();
	boolean go = true;
	do {
		int x = in.read(); // DELEGAZIONE
		if (x!=-1) { // end-of-file not reached
			char ch = (char)x;
			go = (ch!=' ' && ch!='\n' &&
				  ch!='\t' && ch!='\r');
			if (go) buf.append(ch);
		} else go=false;
	} while(go);
	return buf.toString();
  }

 public int readInt() throws IOException {
	return Integer.parseInt(readString());
 }
 public float readFloat() throws IOException {
	return Float.parseFloat(readString());
 }
 public double readDouble() throws IOException {
	return Double.parseDouble(readString());
 }
 public boolean readBoolean() throws IOException {
  	return readString().equals("true");
 }
 public char readChar() throws IOException {
	return readString().charAt(0);
 }
}


