package IO;

import java.io.*;

public class IOUtils {

    public static String readFile(String path){
        File file = new File(path); //создаем абстракный объект
        if(!file.exists()|| !file.isFile()){ //проверяем на возможности
            return null; // возвращаем ноль, чтобы понимать где мы
        }
        else  if(!file.canRead()){
            System.err.println("No access to read"+path);
            return null;// возвращаем ноль, чтобы понимать где мы
        }
        {

            InputStream is =null;
            try {
                is =  new FileInputStream(file);
                //создаем input stream , input - для чтения, output - для записи
           // трай кетчим , так как это требование джавы
                int byteOfData;
                // stream можно представить как массив чисел , когда путь закончен то возвращает -1 , по этому нужна проверка
                StringBuilder builder = new StringBuilder(512);
                while ((byteOfData = is.read())!=-1){
                    char ch = (char) byteOfData;
                   builder.append(ch);
                }
                return builder.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                try {
                    if(is!=null)
                    is.close();
                    System.out.println("Stream has been closed");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void writeFile(String path,String content) {
            write(path,content,false);
        }
        public static void writeOrUpdateFile(String path,String content){
        write(path,content,true);
        }

    private static void write(String path,String content,boolean append){
        File file = new File(path);
        if(file.isDirectory()){
            throw new IllegalArgumentException("Folder is Specified ");
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        OutputStream os=null;
        try {
            os = new FileOutputStream(file,append);
            for(char ch :content.toCharArray()) {
                os.write((byte)ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("OutputStream is close");
            }
        }

    }
    public static String readFileWithBuff(String path){
        StringBuilder sb = new StringBuilder(512);
        File file = new File(path);
        if(!file.exists()|| !file.isFile()){
            return null;
        }
        else  if(!file.canRead()){
            System.err.println("No access to read"+path);
            return null;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            reader.readLine();
            while ((line = reader.readLine())!= null){
                sb.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    private static void writeWithBuff(String path,String content, boolean append){
        File file = new File(path);
        if(file.isDirectory()){
            throw new IllegalArgumentException("Folder is Specified ");
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     try(BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file,append))){
         buffWriter.write(content);
     }  catch (IOException e){
         e.printStackTrace();
     }
    }
    public static void writeOrUpdateFileWithBuff(String path,String content){
        writeWithBuff(path,content,true);
    }
    public static void writeFileWithBuff(String path,String content){
        writeWithBuff(path,content,false);
    }
}
