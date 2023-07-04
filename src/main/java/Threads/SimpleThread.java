package Threads;

public class SimpleThread {
    public static void main(String[] args) {
        ThreadUtils.logBegin(); // показывает лог начала работы
        ThreadUtils.delay(5);// выполняется задержка
        ThreadUtils.logJob("<<<JOB>>>");// выполнение работы
        ThreadUtils.delay(5);
        ThreadUtils.logFinish();// показывает лог конца работы
    }

}
