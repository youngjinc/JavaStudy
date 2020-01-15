package prob13;

import java.util.Random;
import java.util.StringTokenizer;

public class p6_2 {
    public static void main(String[] args) {
        //임의의 시간을 대기한 후 속담을 단어단위로 출력하는 스레드 2개를 테스트하는 프로그램(run() 내부 코드영역 동기화)
        String prov = "Time is money";
        Thread2 t1 = new Thread2(1, prov);
        t1.start();

        int threadNum = 2;
        StringTokenizer provToken = new StringTokenizer(prov, " ");
        synchronized (t1){
            try {
                t1.wait();
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
            }
        }
        while (provToken.hasMoreTokens())
            System.out.println("Proverb" + threadNum + " : " + provToken.nextToken());
    }
}
class Thread2 extends Thread {
    private int threadNum;
    private StringTokenizer provToken;

    public Thread2(int threadNum, String prov) {
        this.threadNum = threadNum;
        this.provToken = new StringTokenizer(prov, " ");
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(new Random().nextInt(2000));
                while (provToken.hasMoreTokens())
                    System.out.println("Proverb" + threadNum + " : " + provToken.nextToken());
                notify();
            } catch (InterruptedException e) {
            }
        }
    }
}