package threadpool;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{

    private Thread currentThread = null;
    private BlockingQueue<Runnable> taskQueue = null;
    private boolean isStopped =false;
    public PoolThreadRunnable(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        currentThread = Thread.currentThread();
        while (!isStopped){
            try {
                Runnable runnable = taskQueue.take();
                System.out.println("Starting : "+ currentThread.getName() );
                runnable.run();
            } catch (InterruptedException e) {

            }
        }

    }

    public void stop(){
        isStopped =true;
        System.out.println("Stopping : "+ currentThread.getName());
        this.currentThread.interrupt();
    }
}
