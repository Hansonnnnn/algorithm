package mutiThread.threadpool;

import java.util.concurrent.CountDownLatch;

public class ThreadPoolTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(7);
    public static void main(String[] args) throws InterruptedException {
        ThreadPool<Job> threadPool = new DefaultThreadPool<>();
        for (int i = 0;i < 7;i++) {
            Job job = new Job();
            threadPool.execute(job);
        }
        countDownLatch.await();
        System.out.println("add worker and remove worker");
        threadPool.addWorkers(2);
        System.out.println(threadPool.getWorkersNum());
        threadPool.removeWorkers(2);
        System.out.println(threadPool.getWorkersNum());
        for (int i = 0;i < 7;i++) {
            Job job = new Job();
            threadPool.execute(job);
        }
    }

    static class Job implements Runnable {
        @Override
        public void run() {
            int count = 0;
            while (count++ < 100000) {
            }
            System.out.println(Thread.currentThread().getName() + " : " + count);
            countDownLatch.countDown();
        }
    }
}
