package safeend;

/**
 * 如何安全的中断线程
 */
public class EndThread {

    private static class UseThread extends Thread {

        public UseThread(String name){
            super(name);
        }

        @Override
        public void run(){
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                System.out.println(threadName + "is run");
            }
            System.out.println(threadName + "thread flag is" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");


        //守护线程与主线程同死，线程中的finally中代码不保证执行
        //endThread.setDaemon(true);

        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();

    }
}
