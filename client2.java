import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class client2 {
    public static void main(String args[]) {
        try {
            Socket soc = new Socket("localhost", 12345);
            System.out.println("connected");
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            String line;
            System.out.println("Hey Hii I'm JavaAI");
            while (!(line = inp.readLine()).equalsIgnoreCase("exit")) 
            {

               
                out.println(line);
                System.out.println("server: " + input.readLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}