import java.io.*;
import java.net.*;
import java.util.*;

public class Calclient {
    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getLocalHost();
        Scanner inp = new Scanner(System.in);
        Socket sock = new Socket(addr, 6666);

        DataInputStream inpStrm = new DataInputStream(sock.getInputStream());
        DataOutputStream outpStrm = new DataOutputStream(sock.getOutputStream());

        try {
            while (true) {
                System.out.println("\n--- Calculator Menu ---");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int oprtr = inp.nextInt();

                outpStrm.writeInt(oprtr);
                if (oprtr == 0) {
                    System.out.println("Exiting...");
                    break;
                }

                String res = inpStrm.readUTF();
                System.out.println("Result from server: " + res);
            }
        } catch (Exception exp) {
            System.out.println("An error occurred: " + exp.getMessage());
        } finally {
            inp.close();
            inpStrm.close();
            outpStrm.close();
            sock.close();
        }
    }
}
