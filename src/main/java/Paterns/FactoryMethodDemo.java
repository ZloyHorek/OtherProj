package Paterns;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        FactoryMethod.getShape('b').draw();
    }
}
//Фабричный метод
class FactoryMethod{
    public static Shape getShape(int num){
        switch (num){
            case 1:
                return new Circle();
            case 2:
                return new Triangle();
            case 3:
                return new Rectangle();
            default:
                //throw
                        new RuntimeException("No such shape #" + num);
        }
        return null;
    }
    public static Shape getShape(char ch){
        switch (ch){
            case 'a':
                return new Circle();
            case 'b':
                return new Triangle();
            case 'c':
                return new Rectangle();
            default:
                //throw
                new RuntimeException("No such shape #" + ch);
        }
        return null;
    }
}
interface Shape{
    void draw();
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("O");
    }
}
class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("   *    ");
        System.out.println("  /_\\");
        System.out.println(" /___\\");
        System.out.println("/_____\\");
    }

}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println(" ________");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println(" --------");
    }
}


