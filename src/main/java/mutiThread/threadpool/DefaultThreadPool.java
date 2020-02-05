package mutiThread.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //jobs 待执行任务的列表，客户端往里面添加，加进去job之后唤醒；工作线程执行，没有需要执行的job就等待
    private final LinkedList<Job> jobs = new LinkedList<>();

    //LinkedList是线程不安全的
    private List<Worker> workers = Collections.synchronizedList(new ArrayList<>());

    private final int MAX_WORKERS_NUM = 10;
    private final int MIN_WORKERS_NUM = 1;
    private final int DEFAULT_WORKERS_NUM = 5;

    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKERS_NUM);
    }

    public DefaultThreadPool(int num) {
        num = num > MAX_WORKERS_NUM ? MAX_WORKERS_NUM : num < MIN_WORKERS_NUM ? MIN_WORKERS_NUM : num;
        initializeWorkers(num);
    }

    @Override
    public void execute(Job job) {
        if(job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        //addWorkers为什么要加锁
        if (MAX_WORKERS_NUM - workers.size() < num) {
            num = MAX_WORKERS_NUM - workers.size();
        }
        initializeWorkers(num);
    }

    @Override
    public void removeWorkers(int num) {
        //为什么要加锁 - 这里加锁不加锁一样吧
        if (num > workers.size()) {
            throw new IllegalArgumentException("beyond workerNum");
        }
        for (int i = 0;i < num;i++) {
            Worker worker = workers.get(i);
            if (workers.remove(worker)) {
                worker.shutdown();
                //这里不需要给threadNum减吗 - 需要
                threadNum.decrementAndGet();
            }
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    @Override
    public int getWorkersNum() {
        return workers.size();
    }

    private void initializeWorkers(int workerNum) {
        for (int i = 0;i < workerNum;i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable {
        private volatile boolean running = true;
        @Override
        public void run() {
            while (running) {
                Job job;
                synchronized (jobs) {
//                if () 这里不能用if，因为如果有线程将该线程唤醒，但还有可能jobs是空的，如果不去检查是否为空，那么下面从jobs中取一个job就可能出错
//                notify()可能没有问题，因为execute()加了一个job进去，然后唤醒一个thread，理论上不可能为空，但是notifyAll()就有可能，所有等待的线程都被唤醒，但是一个抢到了，其他的线程还要判断jobs是否为空
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //感知外部对WorkerThread的中断操作
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                    //接下来就要执行这个job，但是已经没有必要继续持有锁了
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        //job执行过程中的异常，忽略
                    }

                }
            }

        }

        public void shutdown() {
            running = false;
        }
    }
}
