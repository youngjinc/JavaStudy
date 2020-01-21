package prob13;

public class P4 {
    public static void main(String[] args) {
        //세 사람이 산속에서 메아리치는 상황을 동기화한 프로그램
        Echo echo = new Echo();
        Echoer echoer1 = new Echoer("환영", echo);
        Echoer echoer2 = new Echoer("자바", echo);
        Echoer echoer3 = new Echoer("야호~~~", echo);
        echoer1.start();
        echoer2.start();
        echoer3.start();
    }
}
class Echo{
    public void echo(String msg){
        System.out.println(msg);
    }
}
class Echoer extends Thread{
    private String msg;
    private Echo echo;

    public Echoer(String msg, Echo echo) {
        this.msg = msg;
        this.echo = echo;
    }

    @Override
    public void run() {
        synchronized (echo){
            for(int i = 0; i < 3; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                echo.echo(msg);
            }
        }
    }
}