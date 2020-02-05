package mutiThread;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("a");
        threadLocal.set("b");
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
    }
}
