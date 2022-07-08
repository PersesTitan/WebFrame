package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    private final int port;

    //set port
    public Server() {
        this.port = 9090;
    }

    public Server(int port) {
        this.port = port;
    }

    public void connectServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket connectSocket = serverSocket.accept();

            InputStream inputServer = connectSocket.getInputStream();
            OutputStream outputServer = connectSocket.getOutputStream();

            Scanner scanner = new Scanner(inputServer, StandardCharsets.UTF_8);
            PrintWriter serverPrint = new PrintWriter(new OutputStreamWriter(outputServer, StandardCharsets.UTF_8), true);

            serverPrint.println("[OTLanguage Server] Start");
            serverPrint.println(String.format("PORT: %s", port));

            boolean done = false;

            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                serverPrint.println("서버 출력: " + line);

                if (line.strip().equalsIgnoreCase("exit")) {
                    done = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
