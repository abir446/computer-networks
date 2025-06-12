import java.io.*;
import java.net.*;
import java.util.*;

public class Calserver {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server is running... Waiting for a client to connect...");
        Socket sock = server.accept();
        System.out.println("Client connected.");

        DataInputStream inpStrm = new DataInputStream(sock.getInputStream());
        DataOutputStream outpStrm = new DataOutputStream(sock.getOutputStream());
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                int oprtr = inpStrm.readInt();
                if (oprtr == 0) break;

                System.out.print("Enter first number: ");
                int data1 = sc.nextInt();

                System.out.print("Enter second number: ");
                int data2 = sc.nextInt();

                int res;
                switch (oprtr) {
                    case 1:
                        res = data1 + data2;
                        outpStrm.writeUTF("Result: " + res);
                        break;
                    case 2:
                        res = data1 - data2;
                        outpStrm.writeUTF("Result: " + res);
                        break;
                    case 3:
                        res = data1 * data2;
                        outpStrm.writeUTF("Result: " + res);
                        break;
                    case 4:
                        if (data2 == 0) {
                            outpStrm.writeUTF("Error: Division by zero");
                        } else {
                            res = data1 / data2;
                            outpStrm.writeUTF("Result: " + res);
                        }
                        break;
                    default:
                        outpStrm.writeUTF("Invalid operation code!");
                }

                System.out.println("Result sent to the client...");
            }
        } catch (Exception exp) {
            System.out.println("An error occurred: " + exp.getMessage());
        } finally {
            sc.close();
            inpStrm.close();
            outpStrm.close();
            sock.close();
            server.close();
            System.out.println("Server shut down.");
        }
    }
}
