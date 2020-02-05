package reflect.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaInvocationHandler implements InvocationHandler {
    private Object target;

    public JavaInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invocation");
        Object result = method.invoke(target, args);
        System.out.println("after invocation");
        return result;
    }

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}
