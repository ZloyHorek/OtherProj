package collections;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

//Набор (карта) - мэпит ключи на значения, ключ ссылается на значения
public class MapTest {
    @Test
    public void InitialTest() {
        //Изучить класс Node!!!
        Map<String, List<String>> map = new HashMap();
        String key = "J2022";//69877832
        int h;
        h = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(key.hashCode());
        System.out.println(h);
        map.put(key, Arrays.asList("John", "Bob"));
        map.put("J2023", Arrays.asList("Mike K.", "Bob"));
        map.put("J2029", Arrays.asList("Jack", "Alex"));

        map.put("J2022", Arrays.asList("Mike", "Misha"));
        List<String> value = map.get("J2022");
        //put - позволяет дополнить объект, вложить туда 2 значения (Ключ- группа,Значение - Лист)
        assertTrue(value.get(0).equals("Mike"));

        Map<String, List<String>> map2 = new HashMap();
        map2.put("A2022", Arrays.asList("Mike K.", "Bob"));
        map2.put("B2022", Arrays.asList("Mike K.", "Bob"));
        map2.put("J2023", Arrays.asList("Mike K.", "Bob"));
        map.putAll(map2);
        assertEquals(map.size(), 5);

    }

    @Test
    public void collisionTest() {
        Map<Person, Double> map = new HashMap<>();
        map.put(new Person(123, "John"), 6.8);
        map.put(new Person(321, "John"), 6.9);
    }

    @Test
    public void getValueTest() {
        Map<Person, Double> map = new HashMap<>();
        map.put(new Person(123, "John"), 6.8);
        map.put(new Person(321, "John"), 6.9);

        double avg = map.get(new Person(123, "John"));
        assertTrue(avg == 6.8);
        System.out.println("Test pass");
    }

    @Test
    public void getValuesTest() {
        Map<String, List<Person>> map = new HashMap<>();
        map.put("J2022", Arrays.asList(new Person(123, "John"), new Person(321, "Bob")));
        map.put("J3022", Arrays.asList(new Person(77, "Mike"), new Person(55, "Andy")));
        map.put("J2023", Arrays.asList(new Person(788, "Jack"), new Person(566, "Alex")));
        //entrySet вернет множество карт внутри
        //форыч для перебора
        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
            List<Person> value = entry.getValue();
            String key = entry.getKey();

            System.out.println("KEY: " + key);
            for (Person person : value) {
                System.out.println(person.getName());
            }
        }
        //метод  keyset , берет множество ключей и их перебираем
        System.out.println("*************New check*************");
        for (String key : map.keySet()) {
            System.out.println("KEY: " + key);
            for (Person p : map.get(key)) {
                System.out.println(p.getId());
            }
        }
        System.out.println("************* New Check#2 *************");
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(p -> {
                System.out.println(p.getId() + " : " + p.getName());
            });
        });
        System.out.println("Test pass");
    }
    //Свой переберальщик

    @Test
    public void sortTest() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(2, "Two");
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(-5, "Five");

        assertTrue(map.keySet().toString().equals("[-5, 0, 1, 2]")); // не забыть пробелы!!!
    }


        class Person {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Person(int id, String name) {
                this.id = id;
                this.name = name;

            }


            @Override
            public boolean equals(Object o) {
                System.out.println(this.id + "=========EQUALS=========" + ((Person) o).id);
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return id == person.id &&
                        Objects.equals(name, person.name);
            }

            @Override
            public int hashCode() {
                int code = Objects.hash(id, name);
                System.out.println(this.id + "=========HASHCODE=========");
                return code;
            }
        }

    }

