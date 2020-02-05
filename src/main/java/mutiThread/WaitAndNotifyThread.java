package mutiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitAndNotifyThread {
    static volatile boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new WaitThread(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new NotifyThread(), "NotifyThread");
        notifyThread.start();
    }

    static class WaitThread implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " flag is true.wait@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }

                }
            }
            //条件满足时，完成工作
            System.out.println(Thread.currentThread() + " flag is false. running@ "
            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

    static class NotifyThread implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock. notify @"
                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                flag = false; //这行和下一行换位置没有区别
                lock.notify();

                SleepUtils.second(5); // 睡不睡这5s的区别是什么 - 从结果来看更明显
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep@ "
                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
}
