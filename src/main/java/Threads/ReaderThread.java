package Threads;

import IO.FileTester;

public class ReaderThread implements Runnable {
    //Runnable обозначает что клиент должен назначить поток и запустить его
    private String path;
    public ReaderThread(String path){
        this.path=path;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }



    @Override
    public void run() {
        ThreadUtils.logBegin();
        FileTester.printFilesStat(path); // path передается клиентом
        ThreadUtils.logFinish();
    }
}
