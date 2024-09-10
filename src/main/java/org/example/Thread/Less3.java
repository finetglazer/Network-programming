package org.example.Thread;

// Learn about synchronization
class sharedObj {
     synchronized static void print(String string) {
        for (char x : string.toCharArray()) {
            System.out.print(x);
        }
    }
}
public class Less3 {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
           String str1 = "Helloooooooooooooooooooooooooooooooooooooo";
           sharedObj.print(str1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedObj.print("Genji");
        });
        Thread thread2 = new Thread(() -> {
           String str2 = "Thereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
              sharedObj.print(str2);
        });
        thread1.setPriority(7);
        thread1.start();
        thread2.start();
        //ThereeeeHelloooooooooooooooooooooooooooooooooooeeeeeeoooeeeeeeeeeeeeeeeeeeeeeeeeeeee
    }
}
