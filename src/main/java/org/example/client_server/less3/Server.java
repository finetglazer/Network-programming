package org.example.client_server.less3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket( 1117);
        while(true){
            Socket socket = serverSocket.accept();
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            // Say hi using BufferedStream
            byte[] bytes = new byte[1024];
            int lengthRead;
            while((lengthRead = bis.read(bytes)) > 0){
                System.out.println(new String(bytes, 0, lengthRead));
            }

            bos.write("Go out of here".getBytes());
            bos.flush();
            bis.close();
            bos.close();
            socket.close();
        }
    }
}
