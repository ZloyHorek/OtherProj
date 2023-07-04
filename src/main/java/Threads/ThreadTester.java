package Threads;

import java.util.Date;

public class ThreadTester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=====BEGIN=====");
        Thread th = Thread.currentThread(); // создание потока через метод Thread.currentThread()
        th.setName("Main Thread");
        th.setPriority(Thread.MAX_PRIORITY); // изменение приоритета
        th.getName();
        th.getId();
        th.getState();
        th.getPriority();

        System.out.println(th.getId());
        System.out.println(th.getName());
        System.out.println(th.getPriority());
        System.out.println(th.getState());

        ExtraThead extra = new ExtraThead("Extra"); // делаем ссылку на наш поток чтобы тут был виден
        extra.start(); // метод старт позволяет запустить поток

        //Thread.sleep(10000); можно сделать задержку тут чтобы поток притормозил

        for (int i = 0; i <10; i++){
           ExtraThead extraTh = new ExtraThead("Extra th # "+i);
           extraTh.setPriority((int)(Math.random()*10)+1);
           extraTh.start();
        }

        extra.join(1000); // присоединение к потоку, при выполнении можно задать время и потоки пересекутся
        System.out.println("=====END OF MAIN=====");

    }
}
class ExtraThead extends Thread{ //заэкстендили и получили сразу поток
    public ExtraThead(String name){
        setName(name);
        this.setPriority(10);
    }
    // own job is here
    @Override
    public void run(){
        System.out.println(this + "is Started" + new Date());
        for(int i = 0; i<10;i++){
            System.out.println(this.getName()+"["+ this.getPriority()+"]"+"counter is "+i);
            try {
                Thread.sleep(500); // задержка на пол секунды
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this + "is Finished" + new Date());
    }
}