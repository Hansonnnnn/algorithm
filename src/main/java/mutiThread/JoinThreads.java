package mutiThread;

public class JoinThreads {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0;i < 10;i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        System.out.println(Thread.currentThread().getName() + " terminated.");
    }

    static class Domino implements Runnable {
        private Thread previous;
        Domino(Thread previous) {
            this.previous = previous;
        }

        @Override
        public void run() {
            try {
                previous.join();
                System.out.println(Thread.currentThread().getName() + " terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
