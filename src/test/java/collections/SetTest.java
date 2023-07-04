package collections;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class SetTest {
    @Test
    public void InitialTest (){
        //хранит множество уникальных (пар) значений
    HashSet <String> set = new HashSet();
        set.add("One");
        set.add("One");
        set.add("One");
        set.add("ONE");
        set.add("AAA");
        set.add("aaa");
        assertEquals(4 ,set.size());

        for(String str:set){
            System.out.println(str);
        }
        assertEquals("[aaa, One, ONE, AAA]",set.toString());
        set.forEach(s->{
            System.out.println(s.toUpperCase());
        });
    }
    @Test
    public void initialTest2(){
        Set<Map<String,Double>>set = new HashSet<>();
        Map<String,Double>gp1 =new HashMap<>();
        gp1.put ("John",3.5);
        gp1.put ("Bill",4.3);
        gp1.put ("Tim",9.3);
        Map<String,Double>gp2 =new HashMap<>();
        gp2.put ("John",6.5);
        gp2.put ("John",7.2);
        gp2.put ("John",2.3);
        set.add(gp1);
        set.add(gp2);

        for (Map<String,Double> map:set){
            for(Map.Entry<String,Double>entry: map.entrySet()) {

                String k = entry.getKey();
                System.out.println(k);
            }
        }
    }
}



