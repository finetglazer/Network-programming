package org.example.ClientServerWithComplexRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8080);
        System.out.println(client);

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream())
        );
        String strReq =
                "GET / HTTP/1.1 \r\n" +
                        "Host: www.google.com \r\n" +
                        "User-Agent: SimpleBrowser 1.0 \r\n" +
                        "Accept: text/html \r\n\r\n";

        bw.write(strReq);
        bw.flush();

        InputStream is = client.getInputStream();
        byte[] data = new byte[512];
        int bytesRead = 0;
        while ((bytesRead = is.read(data)) != -1) {
            System.out.println(new String(data, 0, bytesRead, "UTF-8"));
        }

        bw.close();
        is.close();
        client.close();
    }
}
