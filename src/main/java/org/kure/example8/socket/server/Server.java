package org.kure.example8.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(10000)) {
            while (true) {
                System.out.println("Waiting for client");
                final Socket accept = ss.accept();
                System.out.println("Client connected " + Thread.currentThread().getName());
                new Thread(new ClientHandler(accept)).start();
            }
        }
    }
}
