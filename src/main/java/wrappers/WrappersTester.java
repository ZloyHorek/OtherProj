package wrappers;


import java.math.BigDecimal;
import java.math.BigInteger;

//���� "�������" - ���� � ������������� ��������� � ���� �������
public class WrappersTester {
    public static void main(String[] args) {

        Long l;
        Boolean b;
        Character c;
        int num =33;
        Integer i = Integer.valueOf(num);//��������� , ����� �������� Integer i = num

        String str = "456";
        //����� ����� ����� parseInt, ����� ����� ����������� �������� ����������
        int x = Integer.parseInt(str);
        x++;
        System.out.println(x);
        System.out.println( Double.parseDouble("2.20000"));
        System.out.println(Boolean.parseBoolean("TRUE "));
        // ��� ������ ������� ����� ������������� ����������� ���������� � ������ ����� ������� �����
        BigDecimal bd;
        BigInteger bi;

        //����������� ������ isLetter,isDigit - ���������� ����� ����� (Character)
        Character ch = Character.valueOf('X');
        Character.isLetter('e');
        Character.isDigit('3');

        Double d2 = 220.2421; //autoboxing
        int val= d2.intValue();
        System.out.println(val);

        Boolean bool = true;
        bool.booleanValue();

        Float f = 53.4f;//autoboxing
        Test(f);

        int ii = 550;
        Integer iiyt =ii;

        Test2(iiyt);

        Test2(666332323+23213123); //��������� ��� ��� Number ��� parent ��� �������� � ������

        int intVal = iiyt;
        long lo = iiyt;

        Test3(iiyt, f.intValue());
    }

    static void Test(Float f){
        System.out.println(f.hashCode());

    }
    static void Test2(Number num){
        System.out.println(num.doubleValue());
    }
    static void Test3(int a,int b ){
        System.out.println(a+b);
    }
}
