package mutiThread;

import java.util.concurrent.CountDownLatch;

public class Hello {

    int exist = 100;
    int empty = 0;

    /**
     * 生产者
     */
    public void produce() {
        while (true) {
            if (empty > 0) {
                synchronized (this) {
                    if (empty > 0) {
                        exist++;
                        empty--;
                        break;
                    }
                }
            }
            System.out.println("produce" + " exist " + exist + " empty " + empty);
        }
    }

    /**
     * 消费者
     */
    public void consume() {
        while (true) {
            if (exist > 0) {
                synchronized (this) {
                    if (exist > 0) {
                        empty++;
                        exist--;
                        break;
                    }
                }
            }
            System.out.println("consume" + " exist " + exist + " empty " + empty);
        }
    }


    public static void main(String[] args) throws InterruptedException{
        Hello hello = new Hello();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 9999050; i++) {
                    hello.produce();
//                    System.out.println(i+ " produce" + " exist " + hello.exist + " empty " + hello.empty);
                }
                countDownLatch.countDown();
            }

        }).start();


        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 9999100; i++) {
                    hello.consume();
//                    在输出下面这行的时候，可能produce已经又执行了一次
//                    System.out.println(i+ " consume" + " exist " + hello.exist + " empty " + hello.empty);
                }
                countDownLatch.countDown();
            }

        }).start();


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(hello.exist);
        System.out.println(hello.empty);

    }
}
