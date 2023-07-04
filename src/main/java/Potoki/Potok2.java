package Potoki;

import java.util.Scanner;

public class Potok2 {
    public static void main(String[] args) {
        Thread1 Thread1 = new Thread1();
        Thread1.start();

        Scanner sc = new Scanner(System.in); // ����� ������� ������������� Enter ��� �������� false � ��������� ������
        sc.nextLine();

        Thread1.shutdown();


    }
}
class Thread1 extends Thread{

    //volatile - �������� ����� ��� ��������� ������
    private volatile boolean running = true; // ������ Enter ����� ��������� �����(� ����� ������)
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
    public void shutdown(){ // ����� ��� ���������� false ��� running � ������ �� �����
        this.running = false;
    }
}
