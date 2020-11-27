package ua.edu.ucu.smartarr;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

abstract class SmartArrayDecorator<T> implements SmartArray<T> {
    @Setter(AccessLevel.PROTECTED) @Getter(AccessLevel.PROTECTED)
    private Object[] array;

    @Override
    public Object[] toArray() {
        return getArray().clone();
    }

    @Override
    public int size() {
        return getArray().length;
    }
}
