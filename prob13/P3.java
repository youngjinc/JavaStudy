package prob13;

import java.util.Random;

public class P3 {
    public static void main(String[] args) {
        //0~9사이의 임의의 정수를 누적하는 2개의 작업스레드를 구성하고 메인스레드는 결과값 2개를 합산하여 출력하는 프로그램
        WorkerThread3 t0 = new WorkerThread3(3,0);
        WorkerThread3 t1 = new WorkerThread3(2,1);
        t0.start();
        t1.start();
        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
        }
        int total = t0.getTotal() + t1.getTotal();
        System.out.println("누적 값 : " + total);
    }
}

class WorkerThread3 extends Thread {
    private int count;
    private int type;
    private int total;

    public int getTotal() {
        return total;
    }

    WorkerThread3(int count, int type) {
        this.count = count;
        this.type = type;
        total = 0;
    }
    @Override
    public void run() {
        int num;
        while (count > 0) {
            num = new Random().nextInt(10);
            total += num;
            System.out.println("Thread-" + type + " : " + num);
            count--;
        }
    }
}
