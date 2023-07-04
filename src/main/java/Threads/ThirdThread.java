package Threads;
import static Threads.ThreadUtils.*;


//��������� ��� ���������� ������ , ��� �� ��������� ������
public class ThirdThread implements Runnable { //������ ������� ������ ���

    @Override
    public void run() {
        logBegin();
        delay(0.2);
        logJob("===JOB===");
        delay(0.2);
        logFinish();
    }
}

class A implements Runnable { //��� �����
    // ����� �� ������� �, �� ���������� �������������
    public A(String name) {
        Thread th = new Thread(this);
        th.setName(name);
        th.start();
    }

    @Override
    public void run() {
        logBegin();
        for (int i = 0; i < 10; i++) { // ��������� ������� ���� ��� �������� �����
            delay(0.1);
            logJob(i);
        }
        logFinish();
    }
}

    class B extends Thread{ //������� ����� , ������� ����� ����� ������ �����
    private Thread thToWait;
    private int timeout;

    public B(Thread toWait,int secToWait){
        setName("<<B>>");
        this.thToWait =toWait;
        this.timeout = secToWait;

    }
        @Override
        public void run() {
            logBegin();
            ThreadUtils.join(thToWait,timeout); // ��������� ����� ���� ��������� ����������� �������
            delay(0.2);
            logJob("===JOB===");
            delay(0.2);
            logFinish();
        }
    }




class ThirdThreadRunner{
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("MAIN"); //������ ���� �������
        ThreadUtils.logBegin();
        //������ ������ ������������� ������
        Thread third = new Thread(new ThirdThread()); // �������� ������ ������ ������, ��� ������������ ������
        third.setName("THIRD");
        third.start();
//        third.join(2000); // ����� ����� ����� 200 ����������, � ����� �������� ���� ������ ����������
        B b = new B(third,1);
        b.start();

        join(third,2);

        A a = new A("<<A>>");

        for(int i = 0; i<10;i++){ // �������� ���� � ����� ���
            new A("A # "+i);
        }

        new Thread(new Runnable() { //���������� ����� , ���������
            @Override
            public void run() {
                logBegin();
                delay(0.2);
                logJob("===EXTRA JOB===");
                delay(0.2);
                logFinish();
            }
        }).start();

        ThreadUtils.logFinish();
    }
}
