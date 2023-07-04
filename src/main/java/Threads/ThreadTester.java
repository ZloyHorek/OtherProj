package Threads;

import java.util.Date;

public class ThreadTester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=====BEGIN=====");
        Thread th = Thread.currentThread(); // �������� ������ ����� ����� Thread.currentThread()
        th.setName("Main Thread");
        th.setPriority(Thread.MAX_PRIORITY); // ��������� ����������
        th.getName();
        th.getId();
        th.getState();
        th.getPriority();

        System.out.println(th.getId());
        System.out.println(th.getName());
        System.out.println(th.getPriority());
        System.out.println(th.getState());

        ExtraThead extra = new ExtraThead("Extra"); // ������ ������ �� ��� ����� ����� ��� ��� �����
        extra.start(); // ����� ����� ��������� ��������� �����

        //Thread.sleep(10000); ����� ������� �������� ��� ����� ����� �����������

        for (int i = 0; i <10; i++){
           ExtraThead extraTh = new ExtraThead("Extra th # "+i);
           extraTh.setPriority((int)(Math.random()*10)+1);
           extraTh.start();
        }

        extra.join(1000); // ������������� � ������, ��� ���������� ����� ������ ����� � ������ �����������
        System.out.println("=====END OF MAIN=====");

    }
}
class ExtraThead extends Thread{ //������������ � �������� ����� �����
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
                Thread.sleep(500); // �������� �� ��� �������
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this + "is Finished" + new Date());
    }
}