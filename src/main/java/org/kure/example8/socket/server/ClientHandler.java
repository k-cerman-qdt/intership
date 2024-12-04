package org.kure.example8.socket.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Client connected " + Thread.currentThread().getName());
        try (Socket socket1 = socket;
             final BufferedReader is = new BufferedReader(new InputStreamReader(socket1.getInputStream(), StandardCharsets.UTF_8));
             final OutputStream os = socket.getOutputStream()
        ) {
            final String name = is.readLine();
            System.out.println("Client name: " + name);
            os.write(("Hello " + name + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
