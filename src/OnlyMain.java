import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class OnlyMain {
    public static void main(String[] args) {
        //虚拟机线程管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        //拿到当前应用程序中线程的信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo:threadInfos) {
            System.out.println("{"+threadInfo.getThreadId()+"} {"+threadInfo.getThreadName()+"}");
        }
    }
}
