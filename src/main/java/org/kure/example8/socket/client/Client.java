package org.kure.example8.socket.client;

import org.kure.example8.socket.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws IOException {
        try (
                Socket localhost = new Socket("localhost", 10000);
                OutputStream os = localhost.getOutputStream();
                final BufferedReader is = new BufferedReader(new InputStreamReader(localhost.getInputStream(), StandardCharsets.UTF_8))
        ) {
            os.write("Kure\n".getBytes());
            System.out.println("Server response = " + is.readLine());

        }
    }
}
