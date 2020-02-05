package mutiThread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        out.connect(in);

        //可能是thread1读取到，也可能是thread2读取到
        Thread thread1 = new Thread(new Print1(in), "PipedPrintThread1");
        thread1.start();
        Thread thread2 = new Thread(new Print2(in), "PipedPrintThread2");
        thread2.start();

        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }

    }

    static class Print1 implements Runnable{
        PipedReader in;
        Print1(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print(Thread.currentThread().getName() + (char) receive);
                }
                System.out.println(Thread.currentThread().getName());
            } catch (IOException e) {
            }
        }
    }

    static class Print2 implements Runnable{
        PipedReader in;
        Print2(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print(Thread.currentThread().getName() + (char) receive);
                }
                System.out.println(Thread.currentThread().getName());
            } catch (IOException e) {
            }
        }
    }
}
