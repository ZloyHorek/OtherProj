package collections;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListTester {

    @Test
    public void initialTest(){ // тестим List
        List list=new ArrayList();// ћожем использовать апкастинг list(также list это абстракци€) в ArrayList.
        // ¬ыгодно делать ссылку обобщенного уровн€ чтобы брать функционал и при этом не делать новую ссылку
        list.add("Val1");
        list.add(123);
        list.add(new ArrayList());
        list.add(new Object());

        assertTrue(list.size()==4);

    }
    @Test
    public void genericTest(){ //дженерики - параметр, который будет использовать коллекци€
        //<? extend E> - продвинутый дженерик. метод способен прин€ть тип который наследует основной
        List<String> list=new ArrayList<String>();
        list.add("Val1");
        list.add("Val2");
        list.add("Val3");

        assertTrue(list.size()==3);
    }
    @Test
    public void Test1(){

        List<String> list=new ArrayList<String>();
        list.add("Val1");
        list.add("Val2");
        list.add("Val3");

        List<String> newList = new ArrayList<>(list);
        newList.add("Val1");
        newList.add(null);
        newList.add(2,"INSERTED_VALUE");

        assertEquals(newList.size(),6);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void Test2(){

        List<String> list=new ArrayList<>(128);
        assertEquals(0,list.size());
        assertTrue(list.isEmpty());
        List<String> listFixedSize= Arrays.asList("One","Two","Three");//добавл€ет массив фиксированной длинны, инфа в каждую €чейку
        assertEquals(3,listFixedSize.size());
        assertFalse(listFixedSize.isEmpty());

        listFixedSize.add("FIVE");
        assertEquals(4,listFixedSize.size());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Test3(){

        List<String> list=new ArrayList<>(128);
        list.add("Zero");
        list.addAll(Arrays.asList("One","Two","Three"));
        list.add("Five");
        assertEquals(5,list.size());
        assertTrue(list.contains(new String("One")));

        assertFalse(list.containsAll(Arrays.asList("One","Two","-1")));

    }
    @Test
    public void Test4(){

        List<Integer> numbers =new ArrayList<>(128);
        numbers.addAll(Arrays.asList(1,2,3,4,5));
        numbers.remove(Integer.valueOf(5));
        assertEquals(4,numbers.size());
        assertEquals(Integer.valueOf(3),numbers.remove(2));
        numbers.set(2,new Integer(66)); // реплейсит, индекс и на что
        //numbers.subList() - возвращает кусок от индекса и до
        Object[] arr = numbers.toArray();
        Object o = arr[2];
        Integer[]arr2 = new Integer[16];
        arr2[0]=1;
        arr2[1]=2;
        arr2[2]=3;

        Integer[] result =  numbers.toArray(arr2);
        assertTrue(result.length!=0);
        numbers.add(-2);
        numbers.add(500);
        numbers.sort(new NumsComparator());
        assertTrue(numbers.get(0)<0);
    }

 @Test
 //тест сортировок
 public void sortTest(){
        List strs =  new ArrayList(Arrays.asList("b","C","A","AA",""));
        strs.sort(String.CASE_INSENSITIVE_ORDER); //константа котора€ позвол€ет игнориривать риестр в ходе сортировки
        assertTrue(strs.get(3).equals("b"));

       // strs.sort(Comparator.naturalOrder());
     List<Integer> nums =new ArrayList<>(Arrays.asList (1,3,2));
     nums.sort(Comparator.naturalOrder());
     assertTrue(nums.get(0).equals(1));

 }
 class  NumsComparator2 implements Comparator<Integer>{

     @Override
     public int compare(Integer o1, Integer o2) {
         return(-1) *o1.compareTo(o2);
     }
 }
    class  NumsComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    @Test
    public void sortCustomTest(){

        List<Car>cars = new ArrayList<>(Arrays.asList(
                new Car(1,"Opel",3.0 , new ArrayList<>(Arrays.asList("Nick","Bob","An","Bob"))),
                new Car(2,"Audi s5",3.0 , new ArrayList<>(Arrays.asList("Alex"))),
                new Car(3,"Audi s5",3.0 , new ArrayList<>(Arrays.asList("Alex","Alex","Bob"))),
                new Car(4,"BMW M5",3.0 , new ArrayList<>(Arrays.asList("Bob")))
    ));
//        cars.sort(Comparator.naturalOrder());
//        assertTrue(cars.get(0).getModel().startsWith("Audi"));
//        cars.sort(new byOwnersNumber());
//        assertEquals(1,cars.get(0).getOwners().size());
//        assertEquals(2,cars.get(1).getOwners().size());

        cars.sort(new byOwnersNames());
        assertEquals(3,cars.get(0).getId());


    }
}


@AllArgsConstructor
@Data
// сортировка машины по определенным данным
class Car implements Comparable<Car>{
    private long id;
    private String model;
    private double vEngine;
    private List<String> owners;

    @Override
    public int compareTo(Car o) {
        return this.model.compareTo(o.model);

    }
}


class NumsComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
class byOwnersNumber implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.valueOf(o1.getOwners().size()).compareTo(o2.getOwners().size()); // сравниваем кол-во овнеров
    }
}

class byOwnersNames implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) { //сравниваем им€ в листе
//        o1.getOwners().sort(Comparator.naturalOrder());
//        o2.getOwners().sort(Comparator.naturalOrder());
        int size = Math.min(o1.getOwners().size(),o2.getOwners().size());

        for(int index = 0; index <size;index++){
            int result = o1.getOwners().get(index).compareTo(o2.getOwners().get(index));
            if(result!=0){
                return o1.getOwners().get(index).compareTo(o2.getOwners().get(index));
            }
        }
        return o1.getOwners().size()-o2.getOwners().size();

    }
}