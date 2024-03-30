package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue<Runnable> taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<PoolThreadRunnable>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int taskSize){
        this.taskQueue = new ArrayBlockingQueue<>(taskSize);

        for (int i = 0; i <noOfThreads ; i++) {
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
            runnables.add(poolThreadRunnable);
        }

        for(PoolThreadRunnable runnable : runnables){
            new Thread(runnable).start();

        }
    }

    public void execute (Runnable task){
        if(isStopped){
            throw new IllegalStateException("ThreadPool is stopped");
        }
        taskQueue.offer(task);
    }

    public void stop(){
        for(PoolThreadRunnable runnable : runnables){
            runnable.stop();
        }
    }

    public void waitUntilAllTaskFinished(){
        while(!this.taskQueue.isEmpty()){
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
