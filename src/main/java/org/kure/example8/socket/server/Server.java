package org.kure.example8.socket.server;

import javax.net.ssl.*;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Server {

    public static void main(String[] args) throws Exception {
        final SSLContext tls = SSLContext.getInstance("TLS");
        final KeyStore jks = KeyStore.getInstance("JKS");
        try (InputStream inputStream = Files.newInputStream(Path.of("/tmp/enc.jks"))) {
            jks.load(inputStream, "pass".toCharArray());
        }
        final KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(jks, "pass".toCharArray());
        tls.init(kmf.getKeyManagers(), new TrustManager[]{
                new X509ExtendedTrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {

                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {

                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
        }, new SecureRandom());
        final SSLServerSocketFactory serverSocketFactory = tls.getServerSocketFactory();
//        try (ServerSocket ss = new ServerSocket(10000)) {
        try (ServerSocket ss = serverSocketFactory.createServerSocket(10000)) {
            while (true) {
                System.out.println("Waiting for client");
                final Socket accept = ss.accept();
                System.out.println("Client connected " + Thread.currentThread().getName());
                new Thread(new ClientHandler(accept)).start();
            }
        }
    }
}
