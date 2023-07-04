package Paterns;
//Разбор Singlton - это паттерн

public class Singleton {
    private static Singleton instance; // создаем статическую переменную instance
    private Singleton(){
        // создаем конструктор Singleton (после getter переходим сюда и выполняем код )

        /**
         * Ленивая имплементация -
         */
        System.out.println("Singleton has been created");
    }
    public static   Singleton getInstance() { // делаем getter для доступа и костыль  для проверки (потом возвращаемся в return)
        if(instance==null)
            instance=new Singleton();
        return instance;
    }
}
class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton(); // ранняя инициализация
    private EagerSingleton(){
        System.out.println("EagerSingleton has been created");
    }

    public static   EagerSingleton getInstance() {
        return instance;
    }
}
class Client {
    public static void main(String[] args) {
        Singleton single = Singleton.getInstance(); // создание экземпляра
        System.out.println(single);
        Singleton single1 = Singleton.getInstance();
        System.out.println(single1);
        Singleton single2= Singleton.getInstance();
        System.out.println(single2);
        Singleton single3 = Singleton.getInstance();
        System.out.println(single3);
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton3 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton1);
        System.out.println(eagerSingleton2);
        System.out.println(eagerSingleton3);

    }
}

