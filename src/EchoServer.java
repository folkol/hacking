import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(12321)) {
            Socket conn;
            while ((conn = serverSocket.accept()) != null) {
                new ClientHandler(conn).start();
            }
        }
    }
}

class ClientHandler extends Thread {

    Socket clientSocket;

    public ClientHandler(Socket s) {
        System.out.println("new connection");
        clientSocket = s;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("recieved: " + line);
                out.println(line);
            }
        } catch (Exception e) {
        }
    }
}