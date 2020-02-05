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
            //��������ʱ����ɹ���
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
                flag = false; //���к���һ�л�λ��û������
                lock.notify();

                SleepUtils.second(5); // ˯��˯��5s��������ʲô - �ӽ������������
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep@ "
                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
}
