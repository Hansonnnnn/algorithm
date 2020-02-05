package reflect.dynamicProxy;

public class MainProxy {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        JavaInvocationHandler handler = new JavaInvocationHandler(helloService);
        HelloService proxy = (HelloService) handler.newProxyInstance();

        proxy.sayHello();
        proxy.sayBye();
    }
}
