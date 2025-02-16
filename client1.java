import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class client1 {
    public static void main(String args[]) {
        try {
            // Connect to the server running on localhost at port 12345
            Socket soc = new Socket("localhost", 12345);
            System.out.println("Connected to the server.");

            // BufferedReader to read user input from the console
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

            // BufferedReader to read messages from the server
            BufferedReader input = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            // PrintWriter to send messages to the server
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            String line;
            System.out.println("Hey Hii, I am JavaAI");

            // Loop to read user input and send it to the server
            while (!(line = inp.readLine()).equalsIgnoreCase("exit")) {
                out.println(line); // Send message to server
                System.out.println("Server: " + input.readLine()); // Read and print server response
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
