package dsAndA;

/**
 * ��д�ݹ�����ʱ���μ�������������
 * 1.��׼����
 * 2.�����ƽ�
 * 3.��Ʒ��򣺼������еݹ���ö������С�
 * 4.�ϳ�Ч��ԭ�������һ�������ʱ�򣬲�Ҫ�ٲ�ͬ�ĵݹ����������ͬ���£�ʲô������ͬ���£�쳲��������ʺϡ�
 *
 *
 * �����Э����
 * �����Э����(covariant)��ָ��
 * �����Base����Sub�Ļ��࣬��ôBase[]����Sub[]�Ļ��ࡣ
 * �������ǲ��ɱ��(invariant)��List<Base>������List<Sub>�Ļ��࣬���������������ࡣ
 *
 *
 * �����Э���Կ��ܻᵼ��һЩ���󣬱�������Ĵ��룺 - ��Ϊ������û��ʾ������ʱ����ҷ�
 * public static void main(String[] args) {
 *      Object[] array = new String[10];
 *      array[0] = 10;
 * }
 *
 * Ҳ�����м��ϵ�Э����
 * ���Square��Shape�����࣬��ôCollection<Square>Ҳ��Collection<Shape>�����࣬����Ǿ���Э����
 * ����ʹ�÷��͵�ȫ��ԭ�򣬾��ǽ�����ʱ�����ɱ���ʱ�������Լ����಻�ǿ�Э���
 * ���ͺͷ��ͼ��ϲ��ǿ�Э��ģ�������ʱ����Ҫ���������
 * ���Ծͳ���ͨ���wildcard
 * Collection<? extends Shape>����Collection<Square>Ҳ�ǿ��Խ��ܵ�
 *
 *
 * �����ض��������ͣ��ڷ�������ֵ��ǰ��
 * ��������������������������������
 * ��Ȩ����������ΪCSDN�������̽�ƽ����ԭ�����£���ѭ CC 4.0 BY-SA ��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
 * ԭ�����ӣ�https://blog.csdn.net/xsc_c/article/details/18010499
 */
public class Chapter1 {
    public static void main(String[] args) {
        printOut(7623);
    }

    private static void printOut(int n) {
        if (n >= 10) {
            printOut(n/10);
        }
        //ȡģ��Ч����ʵ����n % 10 = n - (n / 10)ȡ���� * 10
        System.out.print(n % 10);
    }
}
