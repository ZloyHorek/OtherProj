package init;

public class SuperParent {
    public static int sp;
    // самое первое что инициализируется , это статик поля и статик блоки
    // статический метод можно вызвать без объекта
    static {
        sp=1;
        System.out.println("inside static block of Super parent: " + sp);
    }

    private int sp2;
    public SuperParent(){
        sp2=2;
        System.out.println("Constructor Super Parent: "+sp2);
    }
    // затем не статик поля, но использовать мы их не можем без объекта
    {
        sp2=3;
        System.out.println("Non Static block of Super parent: "+sp2);
    }

    public static  void m(){
        sp=2;
        System.out.println("Static method of Super parent: "+sp);
    }
    public void m2(){
        sp=4;
        System.out.println("Non static method of Super parent: "+sp);
    }


}
