package ListHW;

import OOP.GenericType;

import javax.swing.*;
import java.awt.event.HierarchyBoundsAdapter;
import java.util.*;
import java.util.stream.IntStream;

public class Human {
    private String name;
    private int age;
    private int iq;

    public Human(String name, int age, int iq) {
        this.name = name;
        this.age = age;
        this.iq = iq;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getIq() {
        return iq;
    }
    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", iq=" + iq +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && iq == human.iq && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, iq);
    }
}

class comName implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class comAge implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge()-o2.getAge();
    }
}
class comIQ implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getIq()-o2.getIq();
    }
}




class TestTask2 {
    public static void main(String[] args) {

        List<Human> list = new ArrayList<>();
        list.add(new Human("Alex",27,140));
        list.add(new Human("Alex",27,140));
        list.add(new Human("Bob",23,40));
        list.add(new Human("Sam",30,180));
        list.add(new Human("Jack",20,54));
        list.add(new Human("Alfred",53,183));

//      Object[]myHum = list.toArray();
// тут меняем тип сорта меняя методы
        Collections.sort(list,new comIQ()); //comName - по имени ; comIq - по IQ

// выводим только имя и возраст
        Iterator<Human> iterator = list.iterator();
        while (iterator.hasNext()){
            Human h = iterator.next(); //разобраться, объект(h) перезаписывается по нужным ячейкам
            System.out.println(h.getName()+" "+ h.getAge() );
        }

        System.out.println("************************************");

        Set<Human> s = new LinkedHashSet<>(list); // делаем лист без дублей
        list.clear();
        list.addAll(s);
        System.out.println(list);

        // наш forEach
        System.out.println("************************************");
        list.forEach (hum -> System.out.println("Name: "+hum.getName()
                                                +" Age: "+hum.getAge()
                                                +" IQ: "+hum.getIq()));

        //ПОЧЕМУ Я НЕ МОГУ СДЕЛАТЬ ЭТО ЧЕРЕЗ КОЛЛЕКЦИЮ!!!
        //окей через стрим решить можно, но ничего не понятно, разобраться

        System.out.println("************************************");
        //самое не понятное для меня , лучше конечно сортировать и потом брать первое и последнее значение
        Human max =s.stream().max((x,y)-> x.getIq() - y.getIq()).get();
        Human min =s.stream().min((x,y)-> x.getIq() - y.getIq()).get();

        System.out.println("max: "+max);
        System.out.println("max: "+min);

        System.out.println("************************************");


        Iterator<Human> AllIq = list.iterator(); // достаем все сумму IQ всех в списке
        double IQ = 0;
        while (AllIq.hasNext()) {
            Human Iq = AllIq.next(); // стучим в линейку IQ
            IQ += (double) Iq.getIq();
            System.out.println(IQ);
        }
        //наше среднее значение
        double midIq = IQ/list.size();
        System.out.println("************************************");
        // переменная, объект где ищем (линейка) , затем условие
        list.removeIf(i->i.getIq()<(double)midIq);// удаляем всех у кого IQ ниже среднего
        System.out.println(list);

    }
}

// Словарь не делал , хочу сделать с обращением к Гугл Переводчику - чтобы красиво было,а не через перезапись файла
