package Exceptions.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTester {
    public static void main(String[] args) {
        //�������� ����� ����
        String path = "D:\\readme.txt";
        try {
            InputStream input=new FileInputStream(path);// � ����������� ����� ��������� ���������� ����
            // InputStream ����������� ������ try
            //����� ������������� ������ � ����������� �� ��?
            int b;
            while ((b=input.read())!=-1){
                char ch = (char) b;
                System.out.print(ch);
            }
            // ����� ������� �� ���� �� ���������


        }catch (FileNotFoundException exception){
            exception.printStackTrace();
            System.err.println("File not found from : ");

        }catch (IOException exception){
            exception.printStackTrace();
            System.err.println("Generic I/O exeption : ");

        }



    }
}
