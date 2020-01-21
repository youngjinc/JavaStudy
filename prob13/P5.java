package prob13;

import java.util.Random;
import java.util.StringTokenizer;

public class P5 {
    public static void main(String[] args) {
        //임의의 시간을 대기한 후 속담을 단어단위로 출력하는 스레드 2개를 테스트하는 프로그램
        String prov = "Time is money";
        Printer0 printer = new Printer0();
        new Thread0(1, prov, printer).start();
        new Thread0(2, prov, printer).start();
    }
}

class Thread0 extends Thread {
    private int threadNum;
    private StringTokenizer provToken;
    Printer0 printer;
    public Thread0(int threadNum, String prov, Printer0 printer) {
        this.threadNum = threadNum;
        this.provToken = new StringTokenizer(prov, " ");
        this.printer = printer;
    }

    @Override
    public void run() {
        while (provToken.hasMoreTokens()) {
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
            }
            printer.printProv(threadNum, provToken);
        }
    }
}

//속담 출력 클래스
class Printer0 {
    public void printProv(int threadNum, StringTokenizer provToken){
        System.out.println("Proverb" + threadNum + " : " + provToken.nextToken());
    }
}