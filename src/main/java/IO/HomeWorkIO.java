package IO;

import java.io.*;
import java.util.Scanner;


public class HomeWorkIO {
    public static void Task1(){
        File file = new File("D:\\readme.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
    }
    public static void Task2(){
        String test = "D:\\test";
        File file = new File(test);
        if(file.isDirectory()){
            for(File files:file.listFiles()){
                System.out.println("ѕапка содержит: "+files);
            }
        }
        else {
            System.out.println("ZzZzZz");
        }
    }
    public static void Task3(){
        String testFile = "D:\\A.txt";
        File file = new File(testFile);
        String add = "FILE WAS CREATED VIA JAVA APP!";
        try {
            FileOutputStream writes =new FileOutputStream(testFile);
            byte[]bytesOfData = add.getBytes();
            writes.write(bytesOfData,0,bytesOfData.length);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileInputStream reads =new FileInputStream(testFile);
            int i;
            while ((i=reads.read())!=-1){
                System.out.print((char) i);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Task4(){
        Scanner sc = new Scanner(System.in);
        String testFile = "D:\\A.txt";
        File file = new File(testFile);
        System.out.println("¬ведите текст: ");
        String add = sc.next();
        try {
            FileOutputStream writes =new FileOutputStream(testFile);
            byte[]bytesOfData = add.getBytes();
            writes.write(bytesOfData,0,bytesOfData.length);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Task5(){ // тут сразу все и сканер и числа и тд

        Scanner sc = new Scanner(System.in);
        String testFile = "D:\\A.txt";
        String testFile2 = "D:\\B.txt";
        File file1 = new File(testFile);
        File file2 = new File(testFile2);
        System.out.println("¬ведите текст: ");
        String add = sc.next();
        try {
            FileOutputStream writes =new FileOutputStream(file1);
            FileOutputStream writes2 =new FileOutputStream(file2);
            byte[]bytesOfData = add.getBytes();
            writes.write(bytesOfData,0,bytesOfData.length);
            try(FileInputStream fis=new FileInputStream("D:\\A.txt")){
                int i; // только числа
                while((i=fis.read())!=-1){
                    if((char)i<58&&(char)i>47){
                        writes2.write(i);
                    }
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String Task6() throws IOException { //поиск слова и вывод его индекса (принцип пон€тен)
        // следующие 2 задани€ с заменой не делал, так как тут можно все помен€ть
        File file1 = new File("D:\\3e.txt");
        try (FileInputStream rd=new FileInputStream(file1))
        {
           int i;
            StringBuilder builder = new StringBuilder(512);
            StringBuilder builder2 = new StringBuilder(512);
            while((i=rd.read())!=-1) {
                char ch = (char) i;
                builder.append(ch);
            }
            String text = String.valueOf(builder);
            System.out.print(text);
            if(text.contains("java")){
                int first = builder.indexOf("java");
                for(int f = first; f<first+4;f++){
                    int in = (int) f;
                    builder2.append(in+" ");
                }
                String index = builder2.toString();

                System.out.println("\n"+"Index of java: "+index);
            }
        } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
        return null;
    }



    public static void main (String[] args) throws IOException {
    Task6();
    }
}
