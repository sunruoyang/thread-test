package threadLocal;

/**
 * 使用ThreadLocal
 */
public class UseThreadLocal {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    /**
     * 运行三个线程
     */
    public void startThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestThread(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    /**
     * 测试线程，线程的工作是将ThreadLocal的值变化，并写回，看看线程间是否会相互影响
     */
    public static class TestThread implements Runnable {

        int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ":start");
            Integer s = threadLocal.get();
            s = s + id;
            threadLocal.set(s);
            System.out.println(threadName + ":=========" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLocal useThreadLocal = new UseThreadLocal();
        useThreadLocal.startThreadArray();
    }
}
