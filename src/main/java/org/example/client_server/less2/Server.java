package org.example.client_server.less2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class Server {
    public static void main(String[] args) throws Exception {
       Socket socket = new Socket("localhost", 1117);
       DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        //receive the string
        String string = dis.readUTF();
        System.out.println(string);
        dos.writeUTF("Hi");
        String str = dis.readUTF();
        System.out.println(str);
        dos.writeUTF("Bye server");
        dis.close();
        dos.close();
        socket.close();

    }
}
