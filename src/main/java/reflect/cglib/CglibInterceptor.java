package reflect.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invocation");
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("after invocation");
        return result;
    }

    private Enhancer enhancer = new Enhancer();
    public Object newProxyInstance(Class<?> c) {
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
