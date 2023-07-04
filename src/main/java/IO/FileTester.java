package IO;

import java.io.File;

public class FileTester {
    //

    public static void main(String[] args) {
//        String pathname = "D:\\test"; //указывать конкретно фолдер или файл
//        File file = new File(pathname); // в файл можно положить путь к файлу
//        if (file.exists()) {
//            if (file.isFile()) {
//                System.out.println(pathname + " is File");
//            } else if (file.isDirectory()) {
//                System.out.println(pathname + " is Folder");
//            } else {
//                System.out.println(pathname + "doesn't exist");
//            }
//            //listFiles - позволяет увидеть все содержимое, выводится через массив
//            File d = new File("D:\\");
//            for (File outer : d.listFiles()) {
//                //FOLDER
//                if (outer.isDirectory()) {
//                    System.out.println("FOLDER: " + outer.getName());
//                    File[] files = outer.listFiles();
//                    if (files == null) {
//                        continue;
//                    }
//                    for (File inner : files) {
//                        if (inner.isDirectory()) {
//                            System.out.println("FOLDER: " + inner.getName());
//                        } else {
//                            System.out.println("FILE: " + inner.getName());
//                        }
//                    }
//                } else {
//                    // FILE
//                    System.out.println("FILE: " + outer.getName());
//                }
//            }
//        }
        printFilesStat("D:\\");
    }
public  static   void printFilesStat(String path){
        File file = new File(path);
        if(file.exists()){ // условие если файл существует
            if(file.isFile()){  // условие если файл это файл
                System.out.println("FILE: "+ file.getName());
            }
            else{// условие если это папка
                System.out.println("FOLDER: "+ file.getName());
                File[] files = file.listFiles();
                if(files!=null) {
                    for (File f : files) {
                        printFilesStat(f.getPath());
                    }
                }
            }
        }
        else {
            System.out.println(path+" Doesn't exist");
        }


    }
}
