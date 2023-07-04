package Potoki;


import Threads.Syn.Store;
import Threads.ThreadUtils;

public class Bibl_new {
    public static void main(String[] args) {
    Bible bible = new Bible();
    new Author(bible).start();
    new Reader(bible).start();
    }
}
class Bible {
    //Создаем наш пул книг
    private int counter = 0;
    private int max_counter =20;
    public synchronized int put(){
        if (counter<=max_counter){
            counter++;
            System.out.println("Books velue"+counter+" <<<PUT>>> ");
            return 1;
        }
        return 0;
    }
    public synchronized int get(){
        if(counter>0){
            counter--;
            System.out.println("Books left "+counter+" <<<GET>>> ");
            return 1;
        }
        return 0;
    }
}
class Author extends Thread {
    private Bible bible;
    private int book = 20;
    public Author (Bible bible){
        this.bible=bible;
        setName("<<<Author>>>");
    }
    public void run() {
       while (book>0){
           book-=bible.put();
           ThreadUtils.logJob(getName() + " left to produce : "+ book+" (products)");
           ThreadUtils.delay(0.2);
       }
    }
}
class Reader extends Thread {

        private Bible bible;
        private int book=0;

        public Reader(Bible bible){
            this.bible= bible;
            setName("<<<Reader>>>");
        }

        public void run(){
            while (book<20){
                book+=bible.get();
                ThreadUtils.logJob(getName()+" left to buy: "+(20- book)+"  (Books)");
                ThreadUtils.delay(0.1);
            }
        }
    }