package org.example.client_server.less1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1107);

        while(true) {
            Socket conn = serverSocket.accept();
            System.out.println(conn);
            // nhan ma
            DataInputStream dataInputStream = new DataInputStream(conn.getInputStream());
            String message = dataInputStream.readUTF();
            System.out.println(message);
            //gui a va b
            DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());
            dataOutputStream.writeInt(10);
            dataOutputStream.writeInt(20);
            //nhan kqua
            int result = dataInputStream.readInt();
            System.out.println(result);
            //dong
            System.out.println("Closing connection----------------");
            conn.close();
            dataOutputStream.close();
            dataInputStream.close();
        }


    }
}
