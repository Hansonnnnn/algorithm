package mutiThread.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //jobs ��ִ��������б��ͻ�����������ӣ��ӽ�ȥjob֮���ѣ������߳�ִ�У�û����Ҫִ�е�job�͵ȴ�
    private final LinkedList<Job> jobs = new LinkedList<>();

    //LinkedList���̲߳���ȫ��
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
        //addWorkersΪʲôҪ����
        if (MAX_WORKERS_NUM - workers.size() < num) {
            num = MAX_WORKERS_NUM - workers.size();
        }
        initializeWorkers(num);
    }

    @Override
    public void removeWorkers(int num) {
        //ΪʲôҪ���� - �������������һ����
        if (num > workers.size()) {
            throw new IllegalArgumentException("beyond workerNum");
        }
        for (int i = 0;i < num;i++) {
            Worker worker = workers.get(i);
            if (workers.remove(worker)) {
                worker.shutdown();
                //���ﲻ��Ҫ��threadNum���� - ��Ҫ
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
//                if () ���ﲻ����if����Ϊ������߳̽����̻߳��ѣ������п���jobs�ǿյģ������ȥ����Ƿ�Ϊ�գ���ô�����jobs��ȡһ��job�Ϳ��ܳ���
//                notify()����û�����⣬��Ϊexecute()����һ��job��ȥ��Ȼ����һ��thread�������ϲ�����Ϊ�գ�����notifyAll()���п��ܣ����еȴ����̶߳������ѣ�����һ�������ˣ��������̻߳�Ҫ�ж�jobs�Ƿ�Ϊ��
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //��֪�ⲿ��WorkerThread���жϲ���
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                    //��������Ҫִ�����job�������Ѿ�û�б�Ҫ������������
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        //jobִ�й����е��쳣������
                    }

                }
            }

        }

        public void shutdown() {
            running = false;
        }
    }
}
