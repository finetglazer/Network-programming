package org.example.outin;

import java.io.*;
import java.net.Socket;

public class less1 {
    public static void main(String[] args) throws Exception {
        // out screen
//        OutputStream outputStream = new BufferedOutputStream(System.out);
//        outputStream.write(111111);
//        outputStream.close();
//        //out file
//        OutputStream outputStream1 = new FileOutputStream("output.txt");
//        outputStream1.write(11111);
//        outputStream1.close();
        //out socket
//        Socket socket = new Socket("localhost", 1107);
//        OutputStream outputStream2 = new DataOutputStream(socket.getOutputStream());
//        outputStream2.write
//        (321124);

        //in screen
//        InputStream input = new BufferedInputStream(System.in);
//        while(true) {
//            int tmp = input.read();
//            if (tmp == -1)
//                break;
//            System.out.println(tmp);
//        }
//        input.close();
        //in data
        FileInputStream input1 = new FileInputStream("input.txt");
        while(true) {
            int tmp = input1.read();
            if (tmp == -1)
                break;
            System.out.println(tmp);
        }

        // Attach filter stream to stream
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        BufferedInputStream bin = new BufferedInputStream(fileInputStream);

        InputStream in = new BufferedInputStream( new FileInputStream("input.txt"));

        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream("input.txt"));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("output.txt"));
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = input.read(buffer)) > 0) {
                output.write(buffer, 0, lengthRead);
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
