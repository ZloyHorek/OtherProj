package StringsHW;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTasksSimple {

        //Раздел №1

        //1. Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
        public static void Task1(String s1) {
            System.out.println(s1);
        }

        //2. Распечатать последний символ строки. Используем метод String.charAt().
        public static void Task2(String s1) {
            System.out.println(s1.charAt(s1.length() - 1));
        }

        //3. Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().
        public static void Task3(String s1) {
            System.out.println(s1.endsWith("!!!"));
        }

        //4. Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith().
        public static void Task4(String s1) {
            System.out.println(s1.contains("Java"));
        }

        //5. Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
        public static void Task5(String s1) {
            System.out.println(s1.contains("Java Найти позицию подстроки"));
        }

        //6. Найти позицию подстроки “Java” в строке “I like Java!!!”.
        public static void Task6(String s1) {
            String search = "Java";
            int first = s1.indexOf(search);
            System.out.println();

            //решение при нескольких искомых словах

//        String ste100="I like Java Java Java!!!";
//        String search = "Java";
//        int index200;
//        int counter = 0;
//        while ((index200=ste100.indexOf(search))!=-1){
//            counter++;
//            ste100=ste100.substring(index200+search.length());
//        }
//        System.out.println(counter);
        }

        //7. Заменить все символы “а” на “о”.
        public static void Task7(String s1) {

            System.out.println(s1.replace('a', 'o'));
        }

        //8. Преобразуйте строку к верхнему регистру.
        public static void Task8(String s1) {
            System.out.println(s1.toUpperCase());
        }

        //9. Преобразуйте строку к нижнему регистру
        public static void Task9(String s1) {
            System.out.println(s1.toLowerCase());
        }

        //10. Вырезать строку Java c помощью метода String.substring().
        public static void Task10(String s1) {
            String search = "Java";
            String prefix = s1.substring(0, s1.indexOf(search));
            String suffix = s1.substring(s1.indexOf(search) + search.length());
            String result = prefix.concat(suffix);
            System.out.println(result);
        }
        //Раздел №2

        public static void Task11(int a,int b, int c){
            // Тут же и Task 12 - 13
            StringBuilder sb = new StringBuilder(40);
            String str = sb.append(a).append("+").append(b).append("=").append(c).toString();
            System.out.println(str);
            // Дальше просто меняем значения интов в мейне и создаем любое выражение (тут знак меняем)
            // Таски с заменой
            System.out.println(sb.indexOf("=")); // Для лучшей адаптации, заменяем на нужное нам и получаем индекс для работы
            sb.deleteCharAt(4);
            sb.insert(4," равно ");
            String str2 = sb.toString();
            System.out.println(str2);
        }

        //Раздел №3
        //Напишите метод, заменяющий в строке каждое второе вхождение («object-oriented programming» (не учитываем регистр символов) на «OOP».)
        // не получилось, попробовал и билдер и даже регулярные выражения пощупал



        //Раздел 4
        //Вывод букв(2) в центре строки, строка должна быть четной
        public static void Task15(String str){
            int a = str.length()/3;
            int b=str.length()/2;
            System.out.print(str.charAt(a));
            System.out.print(str.charAt(b));
        }
        //отвратительное решение, но сработало

        //Раздел 5
        public static void Task16(String lastName, int mark, String subject){
        Formatter f = new Formatter();
        f.format("Студент %15s получил %3s по %10s",lastName,mark,subject);
        System.out.println (f);
        }



    public static void main (String[]args)
    {
        String s1 = "I like Java!!!";
        int a = 3;
        int b = 56;
        int c = 59;
        String str = "Strong";





        Task16("Иванов",4,"Алгебра");
        Task15(str);

    }
}


