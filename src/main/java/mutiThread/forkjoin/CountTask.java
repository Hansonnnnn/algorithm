package mutiThread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //����Ҫ�ж������Ƿ��㹻С������㹻С����ֱ��ִ�����񣻲��㹻С���ͼ����ָ�
        //ִ�������� - fork()��fork()�����compute()
        //join()����������ִ�н�����õ����
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start;i <= end;i++) {
                sum += i;
            }
        } else {
            int middle = (end - start) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //execute child task
            leftTask.fork();
            rightTask.fork();
            //join child task result
            int leftSum = leftTask.join();
            int rightSum = rightTask.join();
            sum = leftSum + rightSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,4);
        //execute task
        Future<Integer> result = pool.submit(countTask);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
