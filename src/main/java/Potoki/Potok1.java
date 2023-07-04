package Potoki;

public class Potok1 {
    //в мейне один поток в классе другой
    public static void main(String[] args) throws InterruptedException {
        //до того как мы запустили наш кастомный поток, у нас работает только один поток- main
        //для запуска потока мы должны создать новый объект класса MyThread
        MyThread MyThread = new MyThread();
        //теперь мы должны вызвать метод start (создает новый поток и выполняет то что написано в методе run)
        //если запустить просто run то не будет никакой параллельности, мы просто выполним код из метода run и потом main
        MyThread.start();
        //потоки абсолютно не связаны и не синхронизированы, по этому выдача в консоль не будет постоянной
        MyThread MyThread2 = new MyThread();
        MyThread2.start();

        Thread thread = new Thread(new Runner());
        thread.start();
    }
}
/* Создание потока:
 Способ №1 через наследование класс Thread
 */
class MyThread extends Thread{//класс thread означает новый поток
//для потока мы должны переопределить метод run (Override) в Thread run есть но его нужно переопределить
    public void run() {
        for (int i = 0; i <10;i++){
            try {
                // метод sleep который усыпляет поток, считается в мили секундах
                Thread.sleep(1000); // нужно делать exception
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from MyThread "+i);
        }
    }
}
//второй вариант создания потока, это имплементим интерфейс Runnable у которого только метод Run (способ получше)
class Runner implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10;i++){
            try {
                // метод sleep который усыпляет поток, считается в мили секундах
                Thread.sleep(1000); // нужно делать exception
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from MyThread "+i + " Runnable");
        }
    }
}
