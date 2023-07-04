package init;

public class Child extends Parent{
    public static int sp;
    static {
        sp=1;
        System.out.println("inside static block of Child: " + sp);
    }

    private int sp2;
    public Child(){
        sp2=2;
        System.out.println("Constructor Child: "+sp2);
    }
    {
        sp2=3;
        System.out.println("Non Static block of Child: "+sp2);
    }

    public static  void m(){
        sp=2;
        System.out.println("Static method of Child: "+sp);
    }
    public void m2(){
        sp=4;
        System.out.println("Non static method of Child: "+sp);
    }
}
