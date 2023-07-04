package ListHW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class List_HW_Simple {
    public static void EX1(){
        List<String>colors = new ArrayList<>();//�������� �����
        colors.add("Green");
        colors.add("Red");
        colors.add("Blue");
        colors.add("White");
        colors.add("Black");
        colors.add("Orange");
        System.out.println(colors);
        System.out.println("************************************");
        for (String el:colors){ //������ ����� ����� for
            System.out.println(el);
        }
        System.out.println("************************************");
        colors.add(0,"Pink"); //������� �� ������� (add)
        System.out.println(colors);
        System.out.println("************************************");
        System.out.println(colors.get(0)); // ������� ������ ������� (get)
        System.out.println("************************************");
        colors.set(2,"Yellow"); // ������ �������� ������� ������ ��������� (set)
        System.out.println(colors);
        System.out.println("************************************");
        colors.remove(2);
        System.out.println(colors);
        System.out.println("************************************");
        if (colors.contains("Pink")){ //�������� �� (contains)
            System.out.println("+");
        }
        else {
            System.out.println("-");
        }
        System.out.println("************************************");
        colors.sort(Comparator.naturalOrder()); // sort � ����������� �������, ����� ����� Collections.sort
        System.out.println(colors);
        System.out.println("************************************");
        List<String>colorsCopy = List.copyOf(colors); //����������� "������"  List.copyOf(���������� ����), ����� ����� Collections.copy
        System.out.println(colors);
        System.out.println(colorsCopy);
        System.out.println("************************************");
        Collections.shuffle(colors); //������������ �������� Collections.shuffle
        System.out.println(colors);
        System.out.println("************************************");
        Collections.reverse(colors);// � �������� ������� Collections.reverse
        System.out.println(colors);
        System.out.println("************************************");
        List<String>colorsHalf = colors.subList(0,3);// ������� ���� �� ��������� ���������� sublist()
        System.out.println(colorsHalf);
        System.out.println("************************************");//���������� ��� List ���� ������� ���������� ��������� � 3
        //��� ��� ���������, �������� �� �������� ����� compare
        List<String>c1 = new ArrayList<String>();
        c1.add("Green");
        c1.add("Red");
        c1.add("Blue");
        c1.add("White");
        c1.add("Black");
        c1.add("Orange");
        List<String>c2 = new ArrayList<String>();
        c2.add("Pink");
        c2.add("Red");
        c2.add("Blue");
        c2.add("Black");
        c2.add("Brown");
        List<String>c_final = new ArrayList<String>();
        for (String i:c1){
            c_final.add(c2.contains(i)?"Yes ":"No"); // ��������� ��� ��������� ���������� �������� ���� ����������
            if(c2.contains(i)){ //����������
                c_final.add(i);
            }
        }
        System.out.println(c_final);
        System.out.println("************************************");
        System.out.print(colors);
        Collections.swap(colors,1,5); // ������ ���� ����� swap()
        System.out.print(" After SWAP:  "+colors);
        System.out.println("\n"+"************************************");
        List<String>colorsBig = new ArrayList<>(); // ���������� list ����� addAll
        colorsBig.addAll(colors);
        colorsBig.addAll(c2);
        System.out.println(colorsBig);
        System.out.println("************************************");
        ArrayList<String>cloneNew =((ArrayList<String>) ((ArrayList<String>) colors).clone()); //�� ������� ����� ����� Clone
        System.out.println(colors);
        System.out.println(cloneNew);
        System.out.println("************************************");
        colors.removeAll(colors);//������� ��������� ��� list (removeAll)
        System.out.println(colors);
        System.out.println("************************************");
        System.out.println(colors.isEmpty());
        System.out.println("************************************");
        cloneNew.trimToSize();
        cloneNew.ensureCapacity(10);
        System.out.println("Ex - Trim and Capacity");
        System.out.println("************************************");
        List<String>col = new ArrayList<>();
        col.add("Red");
        col.add("Green");
        String newC = "White";
        col.set(1,newC);
        System.out.println(col);
        System.out.println("************************************");
        int index = colorsBig.size(); // ����� �� �������
        for (int i = 0;i<index;i++){
            System.out.print(colorsBig.get(i)+" ");
            System.out.print(": Index "+i+", ");
        }
    }


    public static void main(String[] args) {
        EX1();
    }
}