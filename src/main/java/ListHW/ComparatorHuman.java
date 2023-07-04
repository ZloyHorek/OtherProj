package ListHW;

import java.util.Comparator;
import java.util.List;

public class ComparatorHuman implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
