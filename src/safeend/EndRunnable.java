package safeend;

/**
 * 中断runnable方式
 */
public class EndRunnable {

    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            //中断为Thread类状态，实现Runnable需用Thread.currentThread().isInterrupted()
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(name+"is run");
            }
            System.out.println(name + "thread flag is"+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread endThread = new Thread(useRunnable,"endThread");
        endThread.start();
        Thread.sleep(20);
        //发出中断通知
        endThread.interrupt();
    }
}
