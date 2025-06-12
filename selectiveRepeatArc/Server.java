import java.io.*;
import java.net.*;
public class SRs {
static ServerSocket serverSocket;
static DataInputStream dis;
static DataOutputStream dos;
static int[] frames;
public static void main(String[] args) {
try {
serverSocket = new ServerSocket(8011);
System.out.println("Waiting for connection");
Socket client = serverSocket.accept();
dis = new DataInputStream(client.getInputStream());
dos = new DataOutputStream(client.getOutputStream());
int numOfFrames = dis.readInt();
frames = new int[numOfFrames];
System.out.println("Received " + numOfFrames + " frames from client:");
for (int i = 0; i < numOfFrames; i++) {
frames[i] = dis.readInt();
System.out.println(frames[i]);
}
int request = requestRetransmission();
dos.writeInt(request);
dos.flush();
if (request != -1) {
int retransmitFrame = dis.readInt();
frames[request] = retransmitFrame;
System.out.println("Received retransmitted frame " + retransmitFrame + " for frame " + (request + 1));
}
System.out.println("Closing connection");
} catch (IOException e) {
System.out.println(e);
} finally {
try {
dis.close();
dos.close();
serverSocket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
static int requestRetransmission() {
for (int i = 0; i < frames.length; i++) {
if (frames[i] == -1) {
return i;
}
}
return -1;
}
}



