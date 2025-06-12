import java.net.*;   
import java.io.*;   
 
class MyClient1 {   
    public static void main(String 
args[]) throws Exception {   
        Socket s = new 
Socket("localhost", 3333);   
 
        DataInputStream din = new 
DataInputStream(s.getInputStream());   
        DataOutputStream dout = new 
DataOutputStream(s.getOutputStream())
 ;   
        BufferedReader br = new 
BufferedReader(new 
InputStreamReader(System.in));   
 
        String str = "", str2 = "";   
 
        while 
(!str.equalsIgnoreCase("stop")) {   
            str = br.readLine();   
            str2 = 
reverseString(str);   
            dout.writeUTF(str2);   
            dout.flush();   
 
            str = din.readUTF();   
            
System.out.println("Server says: " + 
str);   
        }   
 
        dout.close();   
        s.close();   
    }   
    private static String 
reverseString(String s) {   
        StringBuilder sb = new 
StringBuilder(s);   
        return 
sb.reverse().toString();   
    }   
}