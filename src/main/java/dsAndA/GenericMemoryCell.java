package dsAndA;

/**
 * ���ܴ���GenericMemoryCell<int>
 * ͨ��ʹ�÷��ͣ���ǰֻ��������ʱ���ֵĴ��������ڱ����ھͿ��Է���
 * @param <AnyType>
 */
public class GenericMemoryCell<AnyType> {
    private AnyType storedValue;

    public void write(AnyType x) {
        this.storedValue = x;
    }

    public AnyType read() {
        return storedValue;
    }
}
