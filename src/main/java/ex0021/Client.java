package ex0021;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final String IP = args[0];
        final String PORT = args[1];

        InetAddress address = InetAddress.getByName(IP);

        Socket socket = new Socket(address, Integer.parseInt(PORT));
        Scanner scanner = new Scanner(System.in);

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String input;
        do {
            System.out.print("Nachricht: ");
            input = scanner.nextLine();

            bufferedWriter.write(input + System.lineSeparator());
            bufferedWriter.flush();

            String text = bufferedReader.readLine();

            System.out.println("Echo: " + text);
        } while (!input.equals("exit"));
    }
}