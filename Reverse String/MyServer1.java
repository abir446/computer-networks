import java.net.*;   
import java.io.*;   
 
class MyServer1 {   
    public static void main(String 
args[]) throws Exception {   
        ServerSocket ss = new 
ServerSocket(3333);   
        Socket s = ss.accept();   
 
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
            str = din.readUTF();   
            
System.out.println("client says: " + 
str);   
            str2 = 
reverseString(br.readLine());   
            dout.writeUTF(str2);   
            dout.flush();   
        }   
 
        din.close();   
        s.close();   
        ss.close();   
    }   
    private static String 
reverseString(String s) {   
        StringBuilder sb = new 
StringBuilder(s);   
        return 
sb.reverse().toString();   
    }   
} 
