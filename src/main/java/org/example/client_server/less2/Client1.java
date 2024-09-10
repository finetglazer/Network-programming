package org.example.client_server.less2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1117);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("Hello from client");
        dataOutputStream.close();
        socket.close();
    }
}
