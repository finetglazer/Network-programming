package org.example.client_server.less2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.io.ObjectInputStream;

public class Client {
    /*
    We will code a simple code: client will send a message first,
     and server will check it, if it’s okay,
     we will continue to listen, unless it stops immediately.
     In the first case, the server sends the “hello”,
     then the client continues to send the list of lists,
     then the server will return a list containing all the elements of the list by using flatMap.
     */

    public static void main(String[] args) throws IOException {
        // create a client
        while (true) {
            Socket socket = new Socket("localhost", 1107);
            /*
            client and socket are 2 houses, and they receive and send data through their sockets,
            DataInputStream and DataOutputStream is a shipper which use write() and read() to send or receive.
            But the shipper should know where they will go, then they will know the address through
            socket which containing information of goal socket(localhost, 1107)
             */
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //send a security code

            Scanner scanner = new Scanner(System.in);
            String string = scanner.next();
            dos.writeUTF(string);
            //check if our connection is continued or not we continue to code
            try {
                String x = dis.readUTF();
                System.out.println(x);
                dos.writeUTF("Help me merge this list");
                // create and send a list of list
                List<List<String>> list = new LinkedList<>();
                list.add(List.of("By", "the", "way,"));
                list.add(List.of("You","do", "not"));
                list.add(List.of("need", "to", "thank"));
                list.add(List.of("to", "me"));
                ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                ous.writeObject(list);
                // receive the result of the client
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                List<String> result = (List<String>) ois.readObject();
                result.forEach(System.out::print);
            } catch (Exception e) {
                System.out.println("You choose the wrong side");
            } finally {


                dis.close();
                dos.close();
                socket.close();
            }


        }
    }
}
