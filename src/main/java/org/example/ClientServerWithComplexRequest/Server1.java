package org.example.ClientServerWithComplexRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Web server is running...");
        while (true) {
            Socket req = server.accept(); // accept request

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(req.getInputStream())
            );
            String line = br.readLine();
            while (line != null && line.length() > 0) {
                System.out.println(line);
                line = br.readLine();
            }

            System.out.println("Accept request?");

            String strHeader =
                    "HTTP/1.1 200 OK \r\n" +
                            "Content-Type: text/html \r\n\r\n";
            String strBody = "<h1>Server is busy now. Try again later.</h1>";

            req.getOutputStream().write((strHeader + strBody).getBytes());

            br.close();
            req.close();
        }
    }
}
