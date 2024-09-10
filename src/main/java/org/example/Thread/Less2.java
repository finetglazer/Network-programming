package org.example.Thread;

public class Less2 {
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            while(true)
//                System.out.println("thread1 is running");
//        });
//
//        Thread t2 = new Thread(() -> {
//           while (true) {
//                System.out.println("thread2 is running");
//           }
//        });
//
//        t1.setPriority(10);
//        t2.setPriority(1);
//        // higher priority thread will run more often
//        t1.start();
//        t2.start();


//        // join() method and sleep() method
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("thread1 is running");
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("thread2 is running");
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//        t2.start();
//        try {
//            t2.join();// wait for t2 to finish
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t1.start();

        // create a deadlock: 2 threads are waiting for each other to finish
        /*
        Set main Thread priority 10 -> and set another thread daemon -> it will wait for main thread to finish, but we use join for another thread to wait for main thread to finish

         */
        Thread mainThread = Thread.currentThread();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("thread2 is running");
            }
        });

        mainThread.setPriority(10);
        t2.setDaemon(true);
        mainThread.join();
        Thread.yield();
        t2.start();


    }

}
