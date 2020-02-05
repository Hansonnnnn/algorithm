package dsAndA;

/**
 * 编写递归程序的时候，牢记四条基本法则：
 * 1.基准情形
 * 2.不断推进
 * 3.设计法则：假设所有递归调用都能运行。
 * 4.合成效益原则：在求解一个问题的时候，不要再不同的递归调用中做相同的事，什么才是相同的事？斐波那契不适合。
 *
 *
 * 数组的协变性
 * 数组的协变性(covariant)是指：
 * 如果类Base是类Sub的基类，那么Base[]就是Sub[]的基类。
 * 而泛型是不可变的(invariant)，List<Base>不会是List<Sub>的基类，更不会是它的子类。
 *
 *
 * 数组的协变性可能会导致一些错误，比如下面的代码： - 因为编译期没提示，运行时随便乱放
 * public static void main(String[] args) {
 *      Object[] array = new String[10];
 *      array[0] = 10;
 * }
 *
 * 也可以有集合的协变性
 * 如果Square是Shape的子类，那么Collection<Square>也是Collection<Shape>的子类，这就是具有协变性
 * 但是使用泛型的全部原因，就是将运行时错误变成编译时错误，所以集合类不是可协变的
 * 泛型和泛型集合不是可协变的，但是有时候需要这种灵活性
 * 所以就出来通配符wildcard
 * Collection<? extends Shape>这样Collection<Square>也是可以接受的
 *
 *
 * 声明特定泛型类型，在方法返回值的前面
 * ————————————————
 * 版权声明：本文为CSDN博主「蔡金平」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/xsc_c/article/details/18010499
 */
public class Chapter1 {
    public static void main(String[] args) {
        printOut(7623);
    }

    private static void printOut(int n) {
        if (n >= 10) {
            printOut(n/10);
        }
        //取模的效率其实不高n % 10 = n - (n / 10)取下限 * 10
        System.out.print(n % 10);
    }
}
