package StringsHW;

public class StringTasksWeb {
//1. Напишите программу Java для получения символа по заданному индексу в строке.
    public static void Task1(String str1){
      char s1 = str1.charAt(0);
      char s2 = str1.charAt(10);
        System.out.println(s1 +"\n"+s2);

    }
//   2. Напишите программу на Java, чтобы получить символ (кодовая точка Unicode)
//   по заданному индексу в строке.
    public static void Task2(String str2){
        int s1 = str2.codePointAt(1);// codePointAt - возвращает юникод символа по индексу
        int s2 = str2.codePointAt(9);
        char c1= (char)s1;
        char c2= (char)s2;
        System.out.println(s1 +"\n"+s2);
        System.out.println(c1 +"\n"+c2);
    }
    //3. Напишите программу на Java, чтобы получить символ (кодовая точка Unicode)
    // перед указанным индексом в строке.
    public static void Task3(String str2){
        int s1 = str2.codePointBefore(1); // codePointBefore - возвращает юникод символа перед указанным индексом
        int s2 = str2.codePointBefore(9);
        char c1= (char)s1;
        char c2= (char)s2;
        System.out.println(s1 +"\n"+s2);
        System.out.println(c1 +"\n"+c2);
    }
    //4. Напишите программу на Java для подсчета количества кодовых точек Unicode
    // в указанном текстовом диапазоне строки.
    public static void Task4(String str2){
        int s1 = str2.codePointCount(1,9); // Возвращает кол-во символов(точек) в указанном диапазоне
        System.out.println(s1);
    }
    //5-6.Напишите программу на Java для лексикографического сравнения двух строк. (+реестр)
    public static void Task5andTask6(String str1,String str3) {
       int res1 = str1.compareTo(str3);
       int res2 = str1.compareToIgnoreCase(str3);
       System.out.println("Сравнение с учетом реестра: "+res1+"\n"+"Сравнение без учета реестра: "+res2);
    }
    //7. Напишите программу на Java для объединения заданной строки с концом другой строки
    public static void Task7(String str1,String str3) {
        System.out.println(String.join(" ",str1,str3));

    }
    //8. Напишите программу на Java, чтобы проверить, содержит ли заданная строка указанную последовательность значений char.
    public static void Task8(String str1,String str4) { //Метод contains позволяет проверить, содержит ли String другую подстроку
        System.out.println(str1.contains(str4));
    }
    //9. Напишите программу на Java для сравнения заданной строки с заданной последовательностью символов.
    public static void Task9(String str1,String str3) {//contentEquals() – возвращает значение true только в том случае, если эта строка представляет собой ту же последовательность символов
        // которая указана в строке буфера
        System.out.println(str1.contentEquals(str3));
    }

    //10.Напишите программу на Java для сравнения заданной строки с заданным строковым буфером
    public static void Task10(String str1,String str3) {
    StringBuffer st= new StringBuffer(str3);
        System.out.println(str1.contentEquals(st));
    }


    public static void Task11(){
        char [] chars = {'1','2','3','4','5','6','7','8','9'}; // была ошибка так как чары не взял в скобки,исправлено
        String str = String.copyValueOf(chars,0,5); // Метод позволяет копировать часть массива чаров
        // оператор new не нужен
        System.out.println(str);
    }


    public static void Task12(String str1,String str3){
        System.out.println(str1.endsWith("es") +" "+str3.endsWith("es")); // метод сравнивает(boolean) окончание строки
    }







    public static void main(String[] args) {
        String str1 = "Java Exercises";
        String str2 ="w3resource.com ";
        String str3 = "JAVA EXERCISes";
        String str4 = "Java";

        Task12(str1,str3);

    }
}
