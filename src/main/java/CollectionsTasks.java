import java.util.*;

public class CollectionsTasks {
    public static void TaskC_1(){
        int[]array = new int[] {4,2,1,3,3,6,10,4,25,6};
        List <Integer> lst = new ArrayList<>();
        for (int i = 0; i<array.length;i++){
            System.out.print(array[i]+" ");
            lst.add(array[i]);
        }
        System.out.print("\n"+lst+" ");

        lst.sort(Comparator.naturalOrder());//Адекватный порядок
        System.out.print("\n"+lst+" ");

        lst.sort(Comparator.reverseOrder());//Обратный порядок
        System.out.print("\n"+lst+" ");

        Collections.shuffle(lst);//Рандом
        System.out.print("\n"+lst+" ");

        int firstElement = lst.remove(0); // Удаляем первый элемент из списка
        lst.add(firstElement); // Добавляем его в конец списка
        System.out.print("\n"+lst+" ");

//        HashSet<Integer>hs = new HashSet<Integer>(lst); // убираем дубликаты
//        lst.clear();
//        lst.addAll(hs);
//        System.out.print("\n"+lst+" ");

        // Оставляем только дубли
        HashSet<Integer>hs2 = new HashSet<Integer>();
        ArrayList<Integer>dub = new ArrayList<Integer>();
        for (Integer i:lst){
            if (!hs2.add(i)){
                if (!dub.contains(i)){
                    dub.add(i);
                }
            }
        }
        System.out.print("\n"+dub+" ");
        System.out.println();

        Integer [] arr_1 = lst.toArray(new Integer[lst.size()]);
        for (int i =0;i<arr_1.length;i++){
            System.out.print(arr_1[i]+" ");
        }
    }

        public static void main(String[] args) {
        TaskC_1();

        }
    }

