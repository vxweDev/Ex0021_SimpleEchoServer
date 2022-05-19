package ex0021;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Handler implements Runnable {
    private Socket clientSocket;

    public Handler(Socket client) throws SocketException {
        clientSocket = client;
        clientSocket.setSoTimeout(20000);
    }

    @Override
    public void run() {
        System.out.println("Starte Client/Server Kommunikation");
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            String text;
            do {
                text = bufferedReader.readLine();
                System.out.println(text);
                bufferedWriter.write(text + System.lineSeparator());
                bufferedWriter.flush();
            } while (!text.equals("exit"));
            bufferedWriter.close();
            bufferedReader.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
