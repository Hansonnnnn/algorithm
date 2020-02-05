package reflect.dynamicProxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("say hello");
    }

    @Override
    public void sayBye() {
        System.out.println("say bye");
    }
}
