/**
 * 线程star和run的区别
 */
public class StartAndRun {

    private static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 100;
            while (i > 95) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "and now the i = " + i--);
            }
        }
    }

    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        threadRun.setName("beCalled");
        threadRun.run();
        threadRun.start();
    }
}
