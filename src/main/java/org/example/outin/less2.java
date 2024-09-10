package org.example.outin;

import java.io.*;

public class less2 {
    public static void main(String[] args) throws Exception {
//        BufferedWriter writer = new BufferedWriter(new FileWriter("outputUTF8.txt"));
//        writer.write("tôi yêu tôi ");
//        writer.close();
//        OutputStreamWriter writer = new FileWriter("outputUTF8.txt");
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("outputUTF8.txt"));
//        OutputStreamWriter writer1 = new OutputStreamWriter(new FileWriter("outputUTF8.txt"));
        writer.write("Khuyến học-Fukuzawa Yukichi");
        writer.close();


//
//        BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
//        writer2.write("tôi yêu tôi ");
//        writer2.close();

        // Reader from keyboard
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter something: ");
//        String inputString = input.readLine();
//        System.out.println("You entered: " + inputString);
        // Read from file
//        BufferedReader input = new BufferedReader(new FileReader("inputUTF8.txt"));
//        System.out.println("Get this: ");
//        String inputString = input.readLine();
//        System.out.println(inputString);
//        input.close();
    }
}
