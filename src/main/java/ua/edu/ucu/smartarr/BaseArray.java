package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray<T> implements SmartArray<T> {
    private final Object[] array;

    @SafeVarargs
    public BaseArray(T... rawArray) {
        this.array = rawArray.clone();
    }

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public String operationDescription() {
        return "NOP";
    }

    @Override
    public int size() {
        return this.array.length;
    }
}
