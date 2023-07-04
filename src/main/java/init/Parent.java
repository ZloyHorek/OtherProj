package init;

public class Parent extends SuperParent{
    public static int sp;
    static {
        sp=1;
        System.out.println("inside static block of Parent: " + sp);
    }

    private int sp2;
    public Parent(){
        sp2=2;
        System.out.println("Constructor Parent: "+sp2);
    }
    {
        sp2=3;
        System.out.println("Non Static block of  Parent: "+sp2);
    }

    public static  void m(){
        sp=2;
        System.out.println("Static method of  Parent: "+sp);
    }
    public void m2(){
        sp=4;
        System.out.println("Non static method of Parent: "+sp);
    }
}
