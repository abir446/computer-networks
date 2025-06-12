import java.net.Socket;
import java.io.*;

class Clientstr {
public static void main(String args[]) throws Exception {
Socket s = new Socket("localhost", 8888);
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int op;
do {
System.out.println("1-Reverse");
System.out.println("2-Concate");
System.out.println("3-Uppercase");
System.out.println("4-Lowercase");
System.out.println("5-Sentence");
System.out.println("6-Exit");
System.out.println("Enter your Option");
String sop = br.readLine();
op = Integer.parseInt(sop);
dout.writeUTF(sop);
String str1 = "", str2 = "";
switch (op) {
case 1:
System.out.println("Enter a string");
str1 = br.readLine();
dout.writeUTF(str1);
str2 = din.readUTF();
System.out.println("Reverse: " + str2);
dout.flush();
break;
case 2:
System.out.println("Enter a string");
str1 = br.readLine();
System.out.println("Enter a string");
str2 = br.readLine();
dout.writeUTF(str1);
dout.writeUTF(str2);
dout.flush();
str2 = din.readUTF();
System.out.println("Concate: " + str2);
break;
case 3:
System.out.println("Enter a String: ");
str1 = br.readLine();
dout.writeUTF(str1);
str2 = din.readUTF();
System.out.println("Uppercase: " + str2);
break;
case 4:
System.out.println("Enter a String: ");
str1 = br.readLine();
dout.writeUTF(str1);
str2 = din.readUTF();
System.out.println("Lowercase: " + str2);
break;
case 5:
System.out.println("Enter a String: ");
str1 = br.readLine();
dout.writeUTF(str1);
str2 = din.readUTF();
System.out.println("Sentence: " + str2);
break;
case 6:
break;
default:
System.out.println("WRONG INPUT");
break;
}
} while (op != 6);
dout.close();
s.close();
}
}
