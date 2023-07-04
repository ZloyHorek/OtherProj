package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {

    static void tryWithFinally(String str){
        Resource resource1 = null;
        try{
            resource1 = new Resource();
            System.out.println("try block");
            System.out.println(str.length());
        }catch (Exception e){
            System.out.println("catch block");
            e.printStackTrace();
        }finally {
            // Finally блок - отрабатывает всегда и в любом случае, €вл€етс€ не об€зательным
            // ќбычно в нем делают работу по финализации / закрытию
            System.out.println("finalization job");
            try {
                resource1.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void tryWithResources(){
        //try with resource позвол€ет добавить круглые скобки в try
        //модно создать несколько ресурсов
        try(Resource resource1 = new Resource();
            Resource resource2 = new Resource();
            Resource resource3 = new Resource()){
            System.out.println(resource1.toString());
        }catch (Exception e){
            System.out.println("catch block");
            e.printStackTrace();
        }
    }
    String field = "John";

    public static void main(String[] args) {
        System.out.println("Begin.");
        tryWithFinally("TEST");
        System.out.println("****************");
        tryWithResources();
        Tester p = new Tester();
        int[] arr = new int[3];


        int a = 4;
        int b = 2;

        //ќбработка исключений через try and catch
        //¬ыполн€етс€ в момент ошибки
        //¬ catch можно логировать
//        try {
//            int val= arr[2];
//            //ѕотенциально небезопасный код
//            System.out.println(p.field.length());
//            System.out.println(a / b);
//        }
//        catch (ArithmeticException e) {//пытаемс€ словить определенные услови€ из catch
//            System.out.println("Error is here: "+e.getMessage());
//            e.printStackTrace();}
//        catch (NullPointerException e){//дополнительный блог дл€ NullPointerException
//            System.out.println("NULL is here: "+e.getMessage());
//            e.printStackTrace();}
//        catch (Exception e){
//            //общий пул ошибок - upcasting, может словить любой exception так как родительский класс
//            e.printStackTrace();}
////    } catch (ArithmeticException | NullPointerException e ) {// возможность задать сразу две ошибки
////        System.out.println("Error is here: "+e.getMessage());
////    }
            System.out.println("End.");
    }

    static void Calculator() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input num 1");
            int a = sc.nextInt();
            System.out.println("Input operation ");
            char b = sc.next().charAt(0);
            System.out.println("Input num 2");
            int c = sc.nextInt();
            if (b == '+') {
                System.out.println(a + c);
            }
            if (b == '-') {
                System.out.println(a - c);
            }
            if (b == '*') {
                System.out.println(a * c);
            }
            if (b == '/') {
                System.out.println(a / c);
            }
        } catch (ArithmeticException | InputMismatchException e) {
            String msg = e.getMessage();
            System.out.println("Error is here: (" + (msg != null ? msg : "") + " )");
            e.printStackTrace();
        }
    }

    /*
    Basic math operations
    обратить внимание на throws
    @throws IllegalArgumentException ("описание ошибки")
    на примере задаем этот метод дл€ введение некорректной операции
     */

    static void Calculator2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input num #1 :");
        try {
            int num1= sc.nextInt();
            System.out.println("Input num #2 :");
            int num2= sc.nextInt();
            System.out.println("Choose operation (+,-,/*) :");
            String operator = sc.next().trim();
            switch (operator){
                case "+":
                    System.out.println(num1+"+"+num2+"="+(num1+num2));
                    break;
                case "-":
                    System.out.println(num1+"-"+num2+"="+(num1-num2));
                    break;
                case "*":
                    System.out.println(num1+"*"+num2+"="+(num1*num2));
                    break;
                case "/":
                    if(num2==0){
                        throw new IllegalArgumentException("number#2 is 0");
                    }
                    System.out.println(num1+"/"+num2+"="+(num1/num2));
                    break;

                    default:
                    throw new IllegalArgumentException("Incorrect operation has been specified.");
                    // выбрасывает ошибку клиенту, со всеми подробност€ми


            }
        } catch (InputMismatchException | ArithmeticException e) {
            String msg = e.getMessage();
            System.out.println("Error is here: (" + (msg != null ? msg : "") + " )");
            e.printStackTrace();
        }
    }
}