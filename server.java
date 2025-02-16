import java.io.*;  
import java.net.*;  

// Main server class
public class server {
    static int clientnumber = 0; // Counter to track client numbers  

    public static void main(String[] args) {
        try (ServerSocket ser = new ServerSocket(12345)) { // Create a server socket listening on port 12345
            System.out.println("Server is running... Waiting for clients...");

            while (true) { // Infinite loop to keep accepting new clients
                Socket soc = ser.accept(); // Accept client connection
                clientnumber++; // Increment client count
                System.out.println("New client connected: " + soc.getInetAddress());

                // Handle each client in a separate thread
                ClientHandler newThread = new ClientHandler(soc, clientnumber);
                new Thread(newThread).start(); // Start the client handler thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Inner class to handle client communication
    public static class ClientHandler implements Runnable {
        int clientnumber; // Stores the assigned client number
        Socket soc; // Stores the client's socket

        // Constructor to initialize socket and client number
        ClientHandler(Socket soc, int clientnumber) {
            this.soc = soc;
            this.clientnumber = clientnumber;
        }

        // Run method executed in a new thread for each client
        public void run() {
            System.out.println("Client " + clientnumber + " connected");

            try {
                // Input stream to read data from client
                BufferedReader inp = new BufferedReader(new InputStreamReader(soc.getInputStream()));

                // Input stream to read server-side input from the console
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                // Output stream to send data to client
                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

                String line;

                // Keep reading messages from the client until "exit" is received
                while (!(line = inp.readLine()).equalsIgnoreCase("exit")) {
                    System.out.println("Client " + clientnumber + ": " + line); // Display client message

                    out.println(input.readLine()); // Server sends a response from the console
                }

            } catch (Exception e) {
                System.out.println("Client " + clientnumber + " disconnected unexpectedly.");
            }
        }
    }
}
