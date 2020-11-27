package ua.edu.ucu.smartarr;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

abstract class SmartArrayDecorator<T> implements SmartArray<T> {
    @Setter(AccessLevel.PROTECTED)
    private Object[] array;

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public int size() {
        return this.array.length;
    }
}
