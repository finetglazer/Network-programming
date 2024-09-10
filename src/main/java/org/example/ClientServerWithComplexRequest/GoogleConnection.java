package org.example.ClientServerWithComplexRequest;

import java.io.*;
import java.net.*;
/*
This is a bit different from the last lession in that we are sending a GET request to google.com which is a built-in server
and now it is not the issue that we just send a raw, simple data. Now we need to send a request with 3 parts: Type of request, header and body.
 */

public class GoogleConnection {
    public static void main(String[] args) throws IOException {
        // Connect to google.com on port 80
        Socket client = new Socket("www.google.com", 80);
        System.out.println("Connected to Google...");

        // Prepare an HTTP GET request
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String strReq =
                "GET / HTTP/1.1\r\n" +
                        "Host: www.google.com\r\n" +
                        "User-Agent: SimpleBrowser 1.0\r\n" +
                        "Accept: text/html\r\n\r\n";

        // Send the request to Google
        bw.write(strReq);
        bw.flush();

        // Open file to save the response content
        File file = new File("google_response.html");
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));

        // Read the response from Google
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String responseLine;
        boolean saveContent = false; // Start saving content after headers

        while ((responseLine = br.readLine()) != null) {
            if (responseLine.isEmpty()) {
                // An empty line signifies the end of the headers and start of the content
                saveContent = true;
            }
            if (saveContent) {
                fileWriter.write(responseLine);
                fileWriter.newLine();
            }
        }

        // Close the streams and socket
        bw.close();
        br.close();
        fileWriter.close();
        client.close();

        System.out.println("Response saved to google_response.html");
    }
}
