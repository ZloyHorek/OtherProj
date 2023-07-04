package Threads;

import Threads.Syn.Store;

class TestB{
    public static void main(String[] args) {
    Bible bible = new Bible();
    }
}

public class Bible{
    private int counter = 0; //кол-во товаров (счетчик)
    private int max_counter =5;//кол-во товаров максимальное (счетчик)

    //чтобы запустить метод синхронизации нужно создать экземпл€р
    //(синхронайз это спец. модификатор, который придерживает монитор, все ждут во врем€ вызова метода)

    //метод дл€ producer (сколько продуктов на складе - магазе)
    synchronized int put(){
        if (counter<=max_counter){
            counter++;
            System.out.println("Store number of products: "+counter+" <<<PUT>>> ");
            return 1;
        }
        return 0;//максимум товаров , невозможно добавить counter_ max
    }
    synchronized int get(){
        if(counter>0){
            counter--;
            System.out.println("Store number of products: "+counter+" <<<GET>>> ");
            return 1;
        }
        return 0; // нет доступных товаров
    }
}
//делаем класс производител€
class Producer extends Thread{
    private Store store;
    private int product=5;

    //конструктор со стор
    public Producer(Store store){
        this.store= store;
        setName("<<<PRODUCER>>>");
    }

    //ран так как это поток
    @Override
    public void run() {
        while (product>0){
            product-=store.put();
            ThreadUtils.logJob(getName() + " left to produce : "+ product+" (products)");
            ThreadUtils.delay(0.2);
        }
    }
}
class Consumer extends Thread{
    private Store store;
    private int product=0;

    public Consumer(Store store){
        this.store= store;
        setName("<<<CONSUMER>>>");
    }

    @Override
    public void run() {
        while (product<5){
            product+=store.get();
            ThreadUtils.logJob(getName()+" left to consume: "+(5- product)+"  (products)");
            ThreadUtils.delay(0.1);
        }
    }
}


