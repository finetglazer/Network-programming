package org.example.client_server.less2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws Exception {
        // open a server
        ServerSocket serverSocker = new ServerSocket(1117);
        // create a socket
        while(true) {
            Socket socket = serverSocker.accept();
            // create a shipper
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // send hello to the client
            dos.writeUTF("Hello from server");
            // receive the string from the client
            String string = dis.readUTF();
            System.out.println(string);
            dos.writeUTF("Bye");
            System.out.println(dis.readUTF());
            dis.close();
            dos.close();
            socket.close();
        }
    }

}
