package mutiThread.threadpool;

public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorkers(int num);

    int getJobSize(); // 还有多少线程在等待

    int getWorkersNum();
}
