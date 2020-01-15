package prob13;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        //메인 스레드는 키보드에서 입력된 값을 점검해 1이면 MyThread에 인터럽트를 검
        MyThread t = new MyThread();
        t.start();

        Scanner in = new Scanner(System.in);
        String input = in.next();
        if(input.equals("1"))  t.interrupt();
        System.out.println("작업 완료.");
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("작업 실행 중...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }
}
