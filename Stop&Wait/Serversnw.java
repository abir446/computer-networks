import java.io.*;
import java.net.*;
import java.util.*;
public class Serversnw {
private static ServerSocket serverSocket;
private static Socket socket;
private static DataInputStream dataInputStream;
private static DataOutputStream dataOutputStream;
public static void main(String[] args) {
try {
serverSocket = new ServerSocket(8080);
System.out.println("Server is listening on port 8080...");
socket = serverSocket.accept();
System.out.println("Client connected.");
dataInputStream = new DataInputStream(socket.getInputStream());
dataOutputStream = new DataOutputStream(socket.getOutputStream());
String receivedMessage;
String sentMessage;
do {
// Receive message from client
receivedMessage = dataInputStream.readUTF();
System.out.println("Received: " + receivedMessage);
// Send ACK to client
dataOutputStream.writeUTF("ACK");
dataOutputStream.flush();
System.out.println("Sent ACK.");
// Send message to client
System.out.print("Enter message to send: ");
sentMessage = new Scanner(System.in).nextLine();
dataOutputStream.writeUTF(sentMessage);
dataOutputStream.flush();
System.out.println("Sent: " + sentMessage);
} while (!sentMessage.equalsIgnoreCase("stop") && !receivedMessage.equalsIgnoreCase("stop"));
// Close resources
dataInputStream.close();
dataOutputStream.close();
socket.close();
serverSocket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}