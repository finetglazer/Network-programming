package org.example.Thread;


// Learn about synchronization among inter thread communication
class SharedObj4 {
    boolean flag = true;
    int data;

    SharedObj4(int data) {
        this.data = data;
    }
     synchronized void setData(int value) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Data set: " + value);
        this.data = value;
         notify();
         flag = false;



    }
    synchronized void getData() {
        if (flag) {
            try {
               this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Data get: " + data);
        notify();
        flag = true;


    }

}

public class Less4 {
    public static void main(String[] args) {

        SharedObj4 sharedObj4 = new SharedObj4(0);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedObj4.setData(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedObj4.getData();
            }
        });

        thread1.start();
        thread2.start();


    }
}
