package init;

public class Tester {
    public static void main(String[] args) {

        Child ch = new Child();
        System.out.println("****************************");
        Child.m();
        System.out.println("****************************");




        // первыми выводится static блок
        // потом поля и не статика
        // потом конструктор
    }
}
