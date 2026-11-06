import java.io.*;
class readinput {
public static void main(String args[]){
int a = 0, b = 0;
String s;
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   try {
        System.out.print("Primo valore: ");
        a = Integer.parseInt(in.readLine());
        System.out.print("Secondo valore:");
        b = Integer.parseInt(in.readLine());
        s = new String(in.readLine());
        }

        catch (IOException e) {
                    System.out.println("Errore in input");
                    s = "pippolo";
                    }
                                           
        System.out.println("Valori Letti " + a + "  " + b + "  " + s);
  }
}

