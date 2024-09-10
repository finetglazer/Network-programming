package org.example.client_server.less1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1107);
        System.out.println(socket);
        //gui ma
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("Hi I am Hung!");
        //nhan a vs b
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int a = dataInputStream.readInt();
        int b = dataInputStream.readInt();
        System.out.println(a + " " + b);
        //tinh gui server
        int kq = a + b;
        dataOutputStream.writeInt(kq);
        //dong
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
