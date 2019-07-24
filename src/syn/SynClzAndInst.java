package syn;

import tools.SleepTools;

/**
 * 演示对象锁和类锁
 */
public class SynClzAndInst {

    /**
     * 使用类锁的线程
     */
    private static class SynClass extends Thread {

        @Override
        public void run() {
            System.out.println("TestClass is running.....");
            synClass();
        }
    }

    /**
     * 使用对象锁的线程
     */
    private static class InstanceSyn implements Runnable {

        private SynClzAndInst synClzAndInst;

        public InstanceSyn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running ...." + synClzAndInst);
            synClzAndInst.instance();
        }
    }

    /**
     * 使用对象锁的线程
     */
    private static class Instance2Syn implements Runnable {
        private SynClzAndInst synClzAndInst;

        public Instance2Syn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("TestInstance2 is running ...." + synClzAndInst);
            synClzAndInst.instance2();
        }
    }

    private synchronized void instance() {
        SleepTools.second(3);
        System.out.println("synInstance is going ...." + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance is ended" + this.toString());
    }

    private synchronized void instance2() {
        SleepTools.second(3);
        System.out.println("synInstance2 is going ...." + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance2 is ended" + this.toString());
    }

    private static synchronized void synClass() {
        SleepTools.second(3);
        System.out.println("synClass going ....");
        SleepTools.second(3);
        System.out.println("synClass ended");
    }

    public static void main(String[] args) {
        /*对象锁演示*/
//        SynClzAndInst synClzAndInst1 = new SynClzAndInst();
//        Thread t1 = new Thread(new InstanceSyn(synClzAndInst1));
//
//        //SynClzAndInst synClzAndInst2 = new SynClzAndInst();
//        Thread t2 = new Thread(new Instance2Syn(synClzAndInst1));
//
//        t1.start();
//        t2.start();
//
//        SleepTools.second(1);

        /*对象锁和类锁*/
        SynClzAndInst synClzAndInst1 = new SynClzAndInst();
        Thread t1 = new Thread(new InstanceSyn(synClzAndInst1));

        SynClass synClass = new SynClass();

        t1.start();
        synClass.start();
        SleepTools.second(1);
    }
}
