package dsAndA;

/**
 * 不能创建GenericMemoryCell<int>
 * 通过使用泛型，以前只能在运行时发现的错误，现在在编译期就可以发现
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
