package StringsHW;

public class StringTasks {
    //1.На вход подается текст, все предложения, которого начинаются с маленькой буквы. Вывести исправленный текст на консоль.
    //4. Необходимо вывести эту же строку символы которой будут менять свой регистр.
    public static void Task1(String t1) {

        boolean flag = false;
        for (int index = 0; index < t1.length(); index++) {
            char ch = t1.charAt(index);
            if (index == 0) {
                System.out.print((ch + "").toUpperCase());
            } else if (ch == '.' || ch == '!' || ch == '?') {
                flag = true;
                System.out.print(ch);
            } else if (flag && ch != ' ') {
                System.out.print((ch + "").toUpperCase());
                flag = false;
            } else {
                System.out.print(ch);
            }
        }
    }
//2.	На вход подается 1 строка. Необходимо вывести букву, которая встречается в строке дважды.

    public static void Task2(String t2) {
        char[] arr = t2.toCharArray();
        for (int index = 0; index < t2.length(); index++) {
            char ch = arr[index];
            int couter = 1;
            for (int j = index + 1; j < t2.length(); j++) {
                if (ch == arr[j]) {
                    couter++;
                }
            }
            if (couter == 2) {
                System.out.println(ch);
            }
        }

    }

    //3. Необходимо вывести букву, которая встречается в строке больше всего
    public static void Task3(String t2) {

        char[] search = t2.toCharArray();
        for (int i = 0; i < t2.length(); i++) {
            char ch = search[i];
            int counter = 1;
            for (int j = i + 1; j < t2.length(); j++) {
                if (ch == search[j]) {
                    counter++;
                }
            }
            if (counter >= 3) {
                System.out.println(ch);
            }
        }
    }


    //5.	При вводе пользователь выделяет строки используя пробел. Необходимо вывести каждую из этих строк.
    public static void Task5(String t2) {
        //пример метода split который может найти количество элементов
        String[] splitWorlds = t2.split(" ");
        for (String world : splitWorlds) {
            System.out.println(world);
        }
    }

    //6.	На вход подается строка. Известно, что она содержит ровно три одинаковые подстроки длинною в три символа.
    public static String Task6(String t3) {
        // Ну... учитывая что условие позволяет можно сделать так вот)
//        String str = t3.substring(0,3);
//        System.out.println(str);
//        System.out.println(t3);
        char[] search = t3.toCharArray();
        for (int i = 0; i < t3.length(); i++) {
            char ch = search[i];
            int counter = 1;
            for (int j = i + 1; j < t3.length(); j++) {
                if (ch == search[j]) {
                    counter++;
                }
            }
            if (counter == 3) {
                System.out.print(ch);
            }
        }
        System.out.println("\n" + t3);
        return t3;
    }

    //7.	Количество слов в строке
    public static void Task7(String t2) {
        int count = 0;
        char[] ch = t2.toCharArray();
        char s = ' ';
        if (t2.contains(" ")) {
            for (int i : ch) {
                count++;
                break;
            }
            System.out.println(count);
        }
    }

    //8.	Количество строчных и прописных букв в строке
    //Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские буквы.
    public static void Task8(String t2) {
        int count = 0;
        for (int i = 0; i < t2.length(); i++) {
            if (Character.isAlphabetic(t2.charAt(i))) {
                count++;
            }
        }
        System.out.println("Letters amount: " + count);
    }

    //    9.	Самое длинное слово в строке
// Вводится строка слов, разделенных пробелами.
// Найти самое длинное слово и вывести его на экран. Случай, когда самых длинных слов может быть несколько, не обрабатывать.
    public static void Task9(String t2) {
        String[] wordMax = t2.split(" ");
        String st = "";
        for (String word : wordMax) {
            if (word.length() > st.length()) {
                st = word;
            }
            // не могу сообразить как прописать второй if на одинаковый размер , чтобы закончить обработку
        }
        System.out.println(st + " (" + st.length() + ")");
    }

    //    10.	Удаление из строки повторяющихся символов
//Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
// Например, если было введено "abc cde def", то должно быть выведено "abcdef".
    public static void Task10(String t2) {
        // Character.isAlphabetic(t2.charAt(i)
        String result = new StringBuilder(t2).toString();
        result = result.replaceAll("(.)(?=.*\\1)", "");
        result = result.replaceAll("[^A-Za-z0-9]", "");
        result = result.replaceAll("\\s+", "");
        result = new StringBuilder(result).toString();
        System.out.println(result);
        // эти выражения это просто АД, но работают шикарно
    }

    public static void main(String[] args) {
        String t1 = "what makes these topics problematic in terms of research?ObesityThis is very broad." +
                " what about obesity? Causes? effects? relationship to other issues? ";
        String t2 = "Topics ? Problematic in.";
        String t3 = "abcabcabc";
        Task10(t2);

    }
}

