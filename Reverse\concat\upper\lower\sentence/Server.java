import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

class Serverstr {
public static void main(String args[]) throws Exception {
ServerSocket ss = new ServerSocket(8888);
Socket s = ss.accept();
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());
System.out.println("Connected successfully...");
int op;
do {
String sop = din.readUTF();
op = Integer.parseInt(sop);
System.out.println("Option given by the client: " + op);
String str1 = "", str2 = "";
switch (op) {
case 1:
str1 = din.readUTF();
System.out.println("String given by the client: " + str1);
for (int i = 0; i < str1.length(); i++) {
str2 = str1.charAt(i) + str2;
}
dout.writeUTF(str2);
dout.flush();
break;
case 2:
str1 = din.readUTF();
System.out.println("String given by the client: " + str1);
str2 = din.readUTF();
System.out.println("String given by the client: " + str2);
str2 = str1 + " " + str2;
dout.writeUTF(str2);
dout.flush();
break;
case 3:
str1 = din.readUTF();
System.out.println("String given by the client: " + str1);
str2 = str1.toUpperCase();
dout.writeUTF(str2);
dout.flush();
break;
case 4:
str1 = din.readUTF();
System.out.println("String given by the client: " + str1);
str1 = str1.toLowerCase();
char[] arr = str1.toCharArray();
for (int i = 0; i < arr.length; i++) {
arr[i] = Character.toLowerCase(arr[i]);
}
str2 = new String(arr);
dout.writeUTF(str2);
dout.flush();
break;
case 5:
str1 = din.readUTF();
System.out.println("String given by the client: " + str1);
if (!str1.isEmpty()) {
str2 = Character.toUpperCase(str1.charAt(0)) + str1.substring(1).toLowerCase();
}
dout.writeUTF(str2);
dout.flush();
break;
case 6:
break;
default:
System.out.println("WRONG INPUT");
break;
}
} while (op != 6);
din.close();
s.close();
ss.close();
}
}
