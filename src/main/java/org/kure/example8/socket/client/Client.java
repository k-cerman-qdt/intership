package org.kure.example8.socket.client;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Client {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        final SSLContext tls = SSLContext.getInstance("TLS");
        tls.init(null, new TrustManager[]{
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
        final SSLSocketFactory socketFactory = tls.getSocketFactory();
        try (
//                Socket localhost = new Socket("localhost", 10000);
                Socket localhost = socketFactory.createSocket("localhost", 10000);
                OutputStream os = localhost.getOutputStream();
                final BufferedReader is = new BufferedReader(new InputStreamReader(localhost.getInputStream(), StandardCharsets.UTF_8))
        ) {
            os.write("Kure\n".getBytes());
            System.out.println("Server response = " + is.readLine());

        }
    }
}
