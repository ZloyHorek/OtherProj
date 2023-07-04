package Potoki;

import java.util.TreeMap;

public class Synchronize {
    public static void main(String[] args) {
        Thread_1 thread_1 = new Thread_1();
        Thread_1 thread_2 = new Thread_1();
        thread_1.start();
        thread_2.start();

    }
}
class Thread_1 extends Thread{
    @Override
    public void run() {
        super.run();
    }
}

