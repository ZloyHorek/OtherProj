package Threads;

public class Test {
    public static void main(String[] args) {
        ThreadUtils.logBegin();

        MyTread myTread = new MyTread("My Thread");
        myTread.start();

        DemonHelper deamon = new DemonHelper();
        deamon.start();


        Thread reader = new Thread(new ReaderThread("D:\\"));
        reader.setName("Reader Thread");
        reader.start();

        ThreadUtils.delay(3);
        myTread.disable();

        ThreadUtils.logFinish();
    }
}
