package Threads.Syn;

import Threads.ThirdThread;
import Threads.ThreadUtils;

import java.nio.file.attribute.UserPrincipal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Resource {
    private List<Long>ids = new ArrayList<>(); //new Vector

    public List<Long> getIds() {
        return ids;
    }
}

class User implements Runnable {

    private Resource resource;

    public User(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();
//         synchronized (resource) { // синхронизация через команду
            // (каждый джава объект обладает монитором(флаг) придерживается), дает монопольный доступ к объекту
        resource.getIds().clear();
            for (int i = 0; i < 10; i++) {
                String data = resource.getIds().toString();
                ThreadUtils.logJob("<<<<<<OWN LIST(:" + resource.getIds().size() + ") " + data);
                resource.getIds().add(Thread.currentThread().getId());
                ThreadUtils.delay(0.3);
            }
        ThreadUtils.logFinish();
        }

        private synchronized void synchJob(){
            ThreadUtils.logBegin();
//         synchronized (resource) { // синхронизация через команду
            // (каждый джава объект обладает монитором(флаг) придерживается), дает монопольный доступ к объекту
            resource.getIds().clear();
            for (int i = 0; i < 10; i++) {
                String data = resource.getIds().toString();
                ThreadUtils.logJob("<<<<<<OWN LIST(:" + resource.getIds().size() + ") " + data);
                resource.getIds().add(Thread.currentThread().getId());
                ThreadUtils.delay(0.3);
            }
//            synchJob();
            ThreadUtils.logFinish();
        }
}
//}

class SynRunner {
    public static void main(String[] args) {
        ThreadUtils.logBegin();
        Resource res = new Resource();
        for (int i = 0;i<10;i++){
            Thread th = new Thread(new User(res)); // обращение только к одному ресурсу  через new Resourse
            th.setName("USER # "+i);
            th.start();
        }
        ThreadUtils.logFinish();
    }
}

