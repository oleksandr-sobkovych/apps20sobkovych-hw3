package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator<T> implements SmartArray<T> {
    protected Object[] array;

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public int size() {
        return this.array.length;
    }
}
