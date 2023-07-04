package Potoki;

import java.util.Scanner;

public class Potok2 {
    public static void main(String[] args) {
        Thread1 Thread1 = new Thread1();
        Thread1.start();

        Scanner sc = new Scanner(System.in); // через сканнер устанавливаем Enter как значение false и остановки потока
        sc.nextLine();

        Thread1.shutdown();


    }
}
class Thread1 extends Thread{

    //volatile - ключевое слово для остановки потока
    private volatile boolean running = true; // теперь Enter точно остановит поток(в любом случаи)
    public void run() {
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void shutdown(){ // метод для назначения false для running и выхода из цикла
        this.running = false;
    }
}
