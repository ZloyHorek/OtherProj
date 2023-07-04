package Potoki;

public class Potok1 {
    //� ����� ���� ����� � ������ ������
    public static void main(String[] args) throws InterruptedException {
        //�� ���� ��� �� ��������� ��� ��������� �����, � ��� �������� ������ ���� �����- main
        //��� ������� ������ �� ������ ������� ����� ������ ������ MyThread
        MyThread MyThread = new MyThread();
        //������ �� ������ ������� ����� start (������� ����� ����� � ��������� �� ��� �������� � ������ run)
        //���� ��������� ������ run �� �� ����� ������� ��������������, �� ������ �������� ��� �� ������ run � ����� main
        MyThread.start();
        //������ ��������� �� ������� � �� ����������������, �� ����� ������ � ������� �� ����� ����������
        MyThread MyThread2 = new MyThread();
        MyThread2.start();

        Thread thread = new Thread(new Runner());
        thread.start();
    }
}
/* �������� ������:
 ������ �1 ����� ������������ ����� Thread
 */
class MyThread extends Thread{//����� thread �������� ����� �����
//��� ������ �� ������ �������������� ����� run (Override) � Thread run ���� �� ��� ����� ��������������
    public void run() {
        for (int i = 0; i <10;i++){
            try {
                // ����� sleep ������� �������� �����, ��������� � ���� ��������
                Thread.sleep(1000); // ����� ������ exception
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from MyThread "+i);
        }
    }
}
//������ ������� �������� ������, ��� ����������� ��������� Runnable � �������� ������ ����� Run (������ �������)
class Runner implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10;i++){
            try {
                // ����� sleep ������� �������� �����, ��������� � ���� ��������
                Thread.sleep(1000); // ����� ������ exception
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from MyThread "+i + " Runnable");
        }
    }
}
