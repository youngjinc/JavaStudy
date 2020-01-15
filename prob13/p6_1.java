package prob13;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.StringTokenizer;

public class p6_1 {
    public static void main(String[] args) {
        //임의의 시간을 대기한 후 속담을 단어단위로 출력하는 스레드 2개를 테스트하는 프로그램(print() 동기화)
        String prov = "Time is money";
        Printer printer = new Printer();
        new Thread1(1, printer, prov).start();
        new Thread1(2, printer, prov).start();
    }
}
class Thread1 extends Thread {
    private int threadNum;
    private Printer printer;
    private StringTokenizer provToken;

    public Thread1(int threadNum, Printer printer, String prov) {
        this.threadNum = threadNum;
        this.printer = printer;
        this.provToken = new StringTokenizer(prov, " ");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(2000));
            printer.printProv(threadNum, provToken);
            notify();
        } catch (IllegalMonitorStateException e) {
        } catch (InterruptedException e) {
        }
    }
}
//속담 충력 클래스
class Printer{
    public synchronized void printProv(int threadNum, StringTokenizer provToken){
        while (provToken.hasMoreTokens())
            System.out.println("Proverb" + threadNum + " : " + provToken.nextToken());
    }
}
