package org.example.Thread;
// There are 2 ways to create a thread in Java: Runnable, Thread
// Runnable is an interface that is implemented by a class whose instances are intended to be executed by a thread


// 1. Runnable
class Thread1 implements Runnable {
    String name;
    Thread1 (String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true)
            System.out.println(this.name + " is running");
    }
}

// 2. Thread

class Thread2 extends Thread {
    String name;
    Thread2 (String name ) {
        this.name = name;
    }
    @Override
    public void run() {
        while(true)
            System.out.println(name + " is running");
    }
}


public class Less1 {
    public static void main(String[] args) {
        Thread1 t = new Thread1("thread1");
        Thread t2 = new Thread(t);
        Thread2 t3 = new Thread2("thread3");

//        t3.setPriority(10);
        t2.start();
        t3.start();
// using lambda
        Thread t4 = new Thread(() -> {
            while(true)
                System.out.println("thread4 is running");
        });
        t4.start();


    }
}
