package wrappers;

import java.lang.reflect.Array;
import java.util.Arrays;

//Кастомный врапер
public class Storage {
    private static final int DEFAULT_SIZE = 32;
    private static final int FIRST_INDEX = 0;
    public static final int EXTRA_SIZE = 64;
    private int[]data;
    private int currentPos;


    public Storage(){
        this.data = new int[DEFAULT_SIZE]; //refactoring + константа
    }
    public Storage(int initialSize){
        this.data = new int[initialSize];
    }


    //Увеличение массива для избежания ошибки
    public void add (int val){
        checkSize();
        data[currentPos++]=val; //refactoring + field
        System.out.println("New value added");

    }
    private void checkSize(){ //увеличение массива
        if(data.length-currentPos<=0){
            this.data = Arrays.copyOf(data,data.length+ EXTRA_SIZE);
            System.out.println("Data resize");
        }
    }
    public int getFirst(){

        return data[FIRST_INDEX];  //refactoring + field
    }
    public int getLast(){

        return data[currentPos-1];
    }
    public int get(int index){
        if(index<0||index>= data.length){
            System.err.println("Incorrect index: "+index+". Index should be from "+ FIRST_INDEX
            +" to "+(data.length-1));
        }
        return data[index];
    }

}