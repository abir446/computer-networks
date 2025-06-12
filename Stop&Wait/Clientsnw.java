import java.io.*;
import java.net.*;
import java.util.*;
public class Clientsnw {
private static Socket socket;
private static DataInputStream dataInputStream;
private static DataOutputStream dataOutputStream;
public static void main(String[] args) {
try {
socket = new Socket("localhost", 8080);
System.out.println("Connected to server.");
dataInputStream = new DataInputStream(socket.getInputStream());
dataOutputStream = new DataOutputStream(socket.getOutputStream());
String receivedMessage;
String sentMessage;
do {
// Send message to server
System.out.print("Enter message to send: ");
sentMessage = new Scanner(System.in).nextLine();
dataOutputStream.writeUTF(sentMessage);
dataOutputStream.flush();
System.out.println("Sent: " + sentMessage);
// Receive ACK from server
receivedMessage = dataInputStream.readUTF();
System.out.println("Received: " + receivedMessage);
} while (!sentMessage.equalsIgnoreCase("stop") && !receivedMessage.equalsIgnoreCase("stop"));
// Close resources
dataInputStream.close();
dataOutputStream.close();
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}