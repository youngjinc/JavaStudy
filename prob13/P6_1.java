package prob13;

import java.util.Random;
import java.util.StringTokenizer;

public class P6_1 {
    public static void main(String[] args) {
        //P5에서 속담출력 메서드를 동기화한 프로그램 (print() 동기화)
        String prov = "Time is money";
        Printer1 printer = new Printer1();
        new Thread1(1, prov, printer).start();
        new Thread1(2, prov, printer).start();
    }
}
class Thread1 extends Thread {
    private int threadNum;
    private StringTokenizer provToken;
    private Printer1 printer;

    public Thread1(int threadNum, String prov, Printer1 printer) {
        this.threadNum = threadNum;
        this.printer = printer;
        this.provToken = new StringTokenizer(prov, " ");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
        }
        printer.printProv(threadNum, provToken);
    }
}
//속담 출력 클래스
class Printer1{
    public synchronized void printProv(int threadNum, StringTokenizer provToken){
        while (provToken.hasMoreTokens())
            System.out.println("Proverb" + threadNum + " : " + provToken.nextToken());
    }
}
