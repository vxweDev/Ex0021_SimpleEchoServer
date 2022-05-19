package ex0021;

import java.io.IOException;

public class ServerUI {
    public static void main(String[] args) throws IOException {
        Server server = new Server(6000);
        Thread t = new Thread(server);
        t.start();
        System.out.println("Enter stoppt den Server");
        System.in.readNBytes(1);
        System.out.println("Server wird gestoppt");
        server.stopServer();
        System.out.println("Server ist gestoppt");
    }
}
