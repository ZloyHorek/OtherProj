package ThreadHW;

import Threads.ThreadUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Threads_1 {

    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        Resource.addToList();
        System.out.println(currentThread().getName());

        Child_A child_a = new Child_A();
        Child_B child_b = new Child_B();
        Child_C child_c = new Child_C();

        Thread_A A = new Thread_A();
        A.start();
        System.out.println(currentThread().getName());
        child_a.start();
        System.out.println(currentThread().getName());
        Thread_B B = new Thread_B();
        B.start();
        System.out.println(currentThread().getName());
        child_b.start();
        System.out.println(currentThread().getName());
        Thread C = new Thread(new Thread_C());
        C.start();
        System.out.println(currentThread().getName());
        child_c.start();
        System.out.println(currentThread().getName());


    }
//    public static void LogS(){
//        Thread th = Thread.currentThread();
//        System.out.println(th.getName()+"["+ th.getId()+"]"+"is started"+ new Date());
//    }
//    public static void LogJ(Object o){
//        Thread th = Thread.currentThread();
//        System.out.println(th.getName()+"["+ th.getId()+"]"+": "+"["+new Date()+"]"+ o);
//    }
//    public static void LogF(){
//        Thread th = Thread.currentThread();
//        System.out.println(th.getName()+"["+ th.getId()+"]"+"is finished"+ new Date());
//    }
}
class Thread_A extends Thread{
    @Override
    public void run() {
        int couter =0;
        ThreadUtils.logBegin();
        Resource.addToList();
        for(int i = 0;i<10;i++){
            ThreadUtils.logJob(couter++);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Поток A : "+ i);
        }
        ThreadUtils.logFinish();
    }
}
class Thread_B extends Thread{
    @Override
    public void run() {
        int couter =0;
        ThreadUtils.logBegin();
        Resource.addToList();
        for(int i = 0;i<10;i++){
            ThreadUtils.logJob(couter++);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Поток B : "+ i);
        }
        ThreadUtils.logFinish();
    }
}
class Thread_C implements Runnable{
    @Override
    public void run() {
        int couter =0;
        ThreadUtils.logBegin();
        Resource.addToList();
        for(int i = 0;i<10;i++){
            ThreadUtils.logJob(couter++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Поток C : "+ i);
        }
        ThreadUtils.logFinish();
    }
}
class Child_A extends Thread{
    @Override
    public void run() {
        int couter =0;
        ThreadUtils.logBegin();
        Resource.addToList();
        for(int i = 0;i<5;i++){
            ThreadUtils.logJob(couter++);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child_A : "+ i);
        }
        ThreadUtils.logFinish();
    }
}
class Child_B extends Thread{
    @Override
    public void run() {
        int couter =0;
        ThreadUtils.logBegin();
        Resource.addToList();
        for(int i = 0;i<5;i++){
            ThreadUtils.logJob(couter++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child_B : "+ i);
        }
        ThreadUtils.logFinish();
    }
}
class Child_C extends Thread{
    @Override
    public void run() {
        int couter =0;
        ThreadUtils.logBegin();
        Resource.addToList();
        for(int i = 0;i<5;i++){
            ThreadUtils.logJob(couter++);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child_C : "+ i);
        }
        ThreadUtils.logFinish();
    }
}
class Resource{
    public static void addToList (){
        List<String>ThreadsLog=new ArrayList<>();
        Thread th = Thread.currentThread();
        ThreadsLog.add(th.getName());
    }
}
