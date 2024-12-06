package org.kure.example10.samples;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class HttpClientPost {

    public static void main(String[] args) {
        try {
            // Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Define the JSON body to send
            String json = """
                    {
                        "title": "Post Malone",
                        "artist": "Circles",
                        "duration": 1
                    }
                    """;

            // Create an HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/songs"))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(json))
                    .build();

            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
