import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Starting server...");
        try (
                ServerSocket serverSocket = new ServerSocket(12345);
                Socket clientSocket = serverSocket.accept();
                Scanner in = new Scanner(clientSocket.getInputStream())
        ) {
            System.out.println("Client connected.");
            String buffer = "";
            while (in.hasNextLine()) {
                String line = in.nextLine();

                if (line.substring(0, 1).equals("}")) {
                    Data message = new Data(buffer);
                    buffer = "";
                    System.out.println(message);
                } else {
                    buffer += line;
                }

            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 65432 or listening for a connection");
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

