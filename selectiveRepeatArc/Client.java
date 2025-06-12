import java.net.*;
import java.io.*;
import java.util.Scanner;
public class SRc {
static Socket connection;
public static void main(String a[]) {
try {
Scanner scanner = new Scanner(System.in);
InetAddress addr = InetAddress.getByName("localhost");
System.out.println(addr);
connection = new Socket(addr, 8011);
DataOutputStream out = new DataOutputStream(connection.getOutputStream());
DataInputStream in = new DataInputStream(connection.getInputStream());
System.out.print("Enter the number of frames to send: ");
int numOfFrames = scanner.nextInt();
out.writeInt(numOfFrames);
out.flush();
System.out.println("Enter the frames:");
for (int i = 0; i < numOfFrames; i++) {
int frame = scanner.nextInt();
out.writeInt(frame);
out.flush();
}
int request = in.readInt();
if (request != -1) {
System.out.println("Server requests retransmission for frame " + (request + 1));
int retransmitFrame = scanner.nextInt();
out.writeInt(retransmitFrame);
out.flush();
}
System.out.println("Closing connection");
connection.close();
scanner.close();
} catch (IOException e) {
System.out.println(e);
}
}
} 
