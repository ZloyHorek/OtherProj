package ListHW;

import java.util.*;
import java.util.stream.Collectors;

public class List_1 {
    public static void Task1() { //���� � �������� � ������
        List<Integer> listInt = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) listInt.add(i); //���������� ����� � ����
        Collections.shuffle(listInt);// ��� ������
        //System.out.println(listInt);// ����������
        Collections.reverse(listInt);// ��������
        //System.out.println(listInt);// ����������
        /*
        ��� ����� ���� �������� �������� ��� ��������
        listInt.remove(1);
        listInt.add(1,6);
         */
        System.out.println(listInt);
        List<Integer>listInt2= listInt.stream().distinct().collect(Collectors.toList());
        // �������� ���������� �����  stream().distinct() � �������� ������ �����
        System.out.println(listInt2);// ����������
    }



}