package mutiThread.exchanger;

import java.util.concurrent.*;

public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        test();
//        threadPool.execute(() -> {
//            String a = "Bank Reconciliation";
//            try {
//                exchanger.exchange(a);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        threadPool.execute(() -> {
//            try {
//                String b = "Bank Reconciliation";
//                String a = exchanger.exchange(b);
//                System.out.println("A equals B: " + b.equals(a) + " A is: " + a + " B is: " + b);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        threadPool.shutdown();
    }

    private static void test() {
        ExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(10);
        ((ScheduledExecutorService) threadPoolExecutor).schedule(()-> {
            System.out.println(11);
        }, 60L, TimeUnit.MILLISECONDS);

    }
}
