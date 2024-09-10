package org.example.client_server.less3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1117);
        //
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        // Say hi using BufferedStream
        bos.write("Hi".getBytes());// return an array of bytes
        bos.flush();

        // get the message from the server
        socket.shutdownOutput();

        byte[] bytes = new byte[1024];
        int lengthRead;
        while((lengthRead = bis.read(bytes)) > 0){
            System.out.println(new String(bytes, 0, lengthRead));
        }
        bis.close();
        bos.close();
        socket.close();

    }
}
