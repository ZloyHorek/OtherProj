package io;

import IO.IOTasks;
import org.junit.Assert;
import org.junit.Test;

public class TasksTest {
    @Test(timeout = 200 )
    public void testFindTextInFile(){
        String search = "Kasmin didn’t see the three men come into the tavern but he knew they were there almost at once";
        String bookPath = "D:/test/Book.txt";
            Assert.assertTrue(IOTasks.findInFile(bookPath,search));
            Assert.assertFalse(IOTasks.findInFile(bookPath,"Òåêñò ìîé"));
    }
    @Test(expected = RuntimeException.class)
    public void FileNotExist(){
        String search = "Kasmin didn’t see the three men come into the tavern but he knew they were there almost at once";
        String bookPath = "D:/test/123.txt";
        IOTasks.findInFile(bookPath,search);
    }
    @Test(timeout = 200)
    public void Rep(){
        String search = "Kasmin didn’t see the three men come into the tavern but he knew they were there almost at once";
        String rep = "Kasmin";
        String newSt ="Sasha";
        String bookPath = "D:/test/Book.txt";
//        Assert.assertTrue(IOTasks.findInFile(bookPath,search));
        Assert.assertTrue(IOTasks.findInFile(bookPath,newSt));
    }

}
