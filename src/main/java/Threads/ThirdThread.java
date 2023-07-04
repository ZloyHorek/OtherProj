package Threads;
import static Threads.ThreadUtils.*;


//ћеханизмы как объедин€ть потоки , как их запускать не€вно
public class ThirdThread implements Runnable { //ранабл требует потока ран

    @Override
    public void run() {
        logBegin();
        delay(0.2);
        logJob("===JOB===");
        delay(0.2);
        logFinish();
    }
}

class A implements Runnable { //еще поток
    // поток из объекта ј, он запуститс€ автоматически
    public A(String name) {
        Thread th = new Thread(this);
        th.setName(name);
        th.start();
    }

    @Override
    public void run() {
        logBegin();
        for (int i = 0; i < 10; i++) { // добавл€ем простой цикл дл€ проверки джобы
            delay(0.1);
            logJob(i);
        }
        logFinish();
    }
}

    class B extends Thread{ //создаем поток , который будет ждать другой поток
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
            ThreadUtils.join(thToWait,timeout); // указываем класс если возникает пересечение методов
            delay(0.2);
            logJob("===JOB===");
            delay(0.2);
            logFinish();
        }
    }




class ThirdThreadRunner{
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("MAIN"); //выдача имен потокам
        ThreadUtils.logBegin();
        //запуск нового параллельного потока
        Thread third = new Thread(new ThirdThread()); // создание потока внутри потока, дл€ параллельной работы
        third.setName("THIRD");
        third.start();
//        third.join(2000); // джоин будет ждать 200 милисекунд, а потом закончит свою работу независимо
        B b = new B(third,1);
        b.start();

        join(third,2);

        A a = new A("<<A>>");

        for(int i = 0; i<10;i++){ // создание кучи ј через фор
            new A("A # "+i);
        }

        new Thread(new Runnable() { //внутренний класс , анонимный
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
