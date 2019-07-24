import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 新启动线程
 */
public class NewThread {

    /**
     * 实现Runnable接口
     */
    private static class UseRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("I am Runnable");
        }
    }

    /**
     * 实现Callable接口 允许设置返回值
     */
    private static class UseCallble implements Callable<String> {


        @Override
        public String call() throws Exception {
            System.out.println("I am Callable");
            return "Call Result";
        }
    }

    public static void main(String[] args) {
        UseRunnable useRunnable = new UseRunnable();
        Thread threadUseRun = new Thread(useRunnable);
        threadUseRun.start();
        //停止stop()无法保证线程正常释放
        //threadUseRun.stop();
        //挂起suspend()线程不会释放资源
        //threadUseRun.suspend();
        //threadUseRun.resume();

        //中断一个线程 并不是强行关闭（只是通知中断，是否中断由线程自己决定）
        //threadUseRun.interrupt();
        //判断当前线程是否处于中断状态
        //threadUseRun.isInterrupted();


        UseCallble useCallble = new UseCallble();
        //用FutureTask包装Callable为Runnable
        FutureTask<String> futureTask = new FutureTask<>(useCallble);
        Thread threadUseCall = new Thread(futureTask);
        threadUseCall.start();
        //获取CallAble返回值
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
