package Threads;

import java.util.Date;
import java.util.Objects;

//static не нужно создавать экземпл€р
public class ThreadUtils {
    public static void delay(double sec){ // наш метод задержки
        try {
            Thread.sleep((long)(sec*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void join (Thread thread){
            join(thread,0);
    }

    public static void join (Thread thread,int sec){
        try {
            thread.join((long) (sec*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void logBegin (){ // наш метод по отсечке начала потока
        Thread th = Thread.currentThread();
        System.out.println(th.getName()+"["+ th.getId()+"]"+"is started"+ new Date());
    }
    public static void logJob(Object o){ // лог работы
        Thread th = Thread.currentThread();
        System.out.println(th.getName()+"["+ th.getId()+"]"+": "+"["+new Date()+"]"+ o);
    }

    public static void logFinish(){ // лог финиша
        Thread th = Thread.currentThread();
        System.out.println(th.getName()+"["+ th.getId()+"]"+"is finished"+ new Date());
    }
}
