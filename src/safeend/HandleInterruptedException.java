package safeend;

/**
 * 线程中出现InterruptedException处理
 */
public class HandleInterruptedException {

    private static class EndThread extends Thread {
        public EndThread(String name) {
            super(name);
        }

        @Override
        public void run (){
            /*
                如果方法抛出InterruptedException 中断标志位 isInterrupted()会被复位成false
                 */
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    interrupt();
                    System.out.println(isInterrupted());
                }
                System.out.println(isInterrupted());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new EndThread("endThread");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();
    }
}
