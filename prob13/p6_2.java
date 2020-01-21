package prob13;

import java.util.Random;
import java.util.StringTokenizer;

public class P6_2 {
    public static void main(String[] args) {
        //P5에서 run() 내부 코드영역 동기화한 프로그램
        String prov = "Time is money";
        Printer0 printer = new Printer0();
        Thread2 t1 = new Thread2(1, prov, printer);
        Thread2 t2 = new Thread2(2, prov, printer);
        t1.start();
        t2.start();
    }
}
class Thread2 extends Thread {
    private int threadNum;
    private StringTokenizer provToken;
    private Printer0 printer;

    public Thread2(int threadNum, String prov, Printer0 printer) {
        this.threadNum = threadNum;
        this.provToken = new StringTokenizer(prov, " ");
        this.printer = printer;
    }

    @Override
    public void run() {
        synchronized (printer) {
            while (provToken.hasMoreTokens()) {
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                }
                printer.printProv(threadNum, provToken);
            }
        }
    }
}