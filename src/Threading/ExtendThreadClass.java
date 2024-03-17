package Threading;

public class ExtendThreadClass  extends  Thread{
    private int threadNumber;
    public ExtendThreadClass(int threadNumber){
        this.threadNumber = threadNumber;
    }
    @Override
    public void run(){
        for (int i = 0; i <5 ; i++) {
            System.out.println(i + " Thread " +  threadNumber);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }


}
