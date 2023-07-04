package Threads;

import Swing.XMLCurrencyParser;

public class DemonHelper extends Thread {
    public DemonHelper(){ //если поток демон он умирает когда потоки умирают (не демоны)
        setDaemon(true); // создаем демона
        setName("Daemon Thread");// даем имя
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();
        while (true) {
            String usdStrValue = XMLCurrencyParser.getCurrency("USD");
            ThreadUtils.logJob("USD CURRENCY Rate is "+usdStrValue);
            ThreadUtils.delay(0.2);

        }
        //ThreadUtils.logFinish();
    }
}
