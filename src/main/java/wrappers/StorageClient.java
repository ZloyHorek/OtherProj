package wrappers;

public class StorageClient {
    public static void main(String[] args) {
        System.out.println("Begin");
        Storage storage1 = new Storage(2);
        Storage storage2 = new Storage();
        storage1.add(46);
        storage1.add(455);
        storage1.add(-55);
        storage1.add(Integer.MAX_VALUE);
        System.out.println("FIRST: " + storage1.getFirst());
        System.out.println("LAST: " + storage1.getLast());

        int index = 2;
        System.out.println("Element: "+storage1.get(index));
        int val = storage1.get(4);
        val = val+67;
        System.out.println("Value is "+ val);
        System.out.println("end.");


    }
}
