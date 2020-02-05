package reflect.cglib;


public class CglibMain {
    public static void main(String[] args) {
        CglibInterceptor interceptor = new CglibInterceptor();
        CglibClass cglibClass = (CglibClass)interceptor.newProxyInstance(CglibClass.class);
        cglibClass.sayHello();
        cglibClass.sayBye();
    }
}
