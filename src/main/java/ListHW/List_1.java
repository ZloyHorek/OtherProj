package ListHW;

import java.util.*;
import java.util.stream.Collectors;

public class List_1 {
    public static void Task1() { //лист с рандомом и прочим
        List<Integer> listInt = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) listInt.add(i); //добавление чисел в лист
        Collections.shuffle(listInt);// наш рандом
        //System.out.println(listInt);// проверочка
        Collections.reverse(listInt);// разворот
        //System.out.println(listInt);// проверочка
        /*
        тут нужно было добавить дубликат для проверки
        listInt.remove(1);
        listInt.add(1,6);
         */
        System.out.println(listInt);
        List<Integer>listInt2= listInt.stream().distinct().collect(Collectors.toList());
        // удаление дубликатов через  stream().distinct() и создание нового листа
        System.out.println(listInt2);// проверочка
    }



}