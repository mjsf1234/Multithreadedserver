package Threading;

public class ImplRunnableClass implements  Runnable{
    private int threadNumber;
    public ImplRunnableClass(int threadNumber){
        this.threadNumber = threadNumber;
    }
    @Override
    public void run(){
        for (int i = 0; i <5 ; i++) {
            System.out.println(i + " Thread " +  threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

}
