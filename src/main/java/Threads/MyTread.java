package Threads;

public class MyTread extends Thread{
//run+ TAB
    private boolean isActive;
    public MyTread(String name){
        this.setName(name);
        this.isActive=true;
    }

    public void disable(){
        isActive=false;
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();
        int counter = 0;
        while (isActive){
            ThreadUtils.logJob(counter++);
            ThreadUtils.delay(0.5);
        }
        ThreadUtils.logFinish();
    }
}
