package thread;

public class Processor extends Thread{
    private volatile boolean running =true;
    @Override
    public void run(){
        while(running) {
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        running=false;
    }
}
