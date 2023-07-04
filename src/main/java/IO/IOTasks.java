package IO;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class IOTasks {
    public static boolean findInFile(String filePath, String search) {
        String content = IOUtils.readFileWithBuff(filePath);
        if (content == null) {
            throw new RuntimeException("Not exist" + filePath);
        }
        return content.toLowerCase().contains(search.toLowerCase());
    }

    public static void Replace(String path, String str1, String ste2) {
        String filecontent = IOUtils.readFileWithBuff(path);
        if (filecontent == null) {
            throw new RuntimeException("File not exist. Path is" + path);
        }
        String file2 = filecontent.replaceAll("Stephen Deas", "Maria Bondor");
        IOUtils.writeFile("D:/test/Book.txt", file2);
    }
}

