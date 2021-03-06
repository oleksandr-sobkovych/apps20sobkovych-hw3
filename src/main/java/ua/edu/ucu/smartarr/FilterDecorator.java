package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator<T> extends SmartArrayDecorator<T> {
    public FilterDecorator(SmartArray<T> smartArray, MyPredicate pr) {
        setArray(Arrays.stream(
                smartArray.toArray()).filter(pr::test).toArray());
    }

    @Override
    public String operationDescription() {
        return "Filter items from array";
    }
}
