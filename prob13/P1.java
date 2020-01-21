package prob13;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        //1초 단위의 타이머 프로그램 (단,p입력시 종료 후 경과시간을 출력)
        Timer timer = new Timer();
        Thread t = new Thread(timer);
        t.start();
        Scanner in = new Scanner(System.in);
        if(in.next().equals("p")) t.interrupt();
        System.out.println(timer.getTime());
    }
}

class Timer implements Runnable {
    private int time = 0;

    public int getTime() {
        return time;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                time += 1;
            }
        } catch (InterruptedException e) {
        }
    }
}
