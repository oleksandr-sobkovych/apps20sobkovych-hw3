package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator<T> extends SmartArrayDecorator<T> {

    public SortDecorator(SmartArray<T> smartArray, MyComparator cmp) {
        this.array = Arrays.stream(
                smartArray.toArray()).sorted(cmp).toArray();
    }

    @Override
    public String operationDescription() {
        return "Sort items in array";
    }
}
