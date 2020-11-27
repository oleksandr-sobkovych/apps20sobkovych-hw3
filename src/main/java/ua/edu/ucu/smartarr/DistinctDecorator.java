package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator<T> extends SmartArrayDecorator<T> {

    public DistinctDecorator(SmartArray<T> smartArray) {
        super(smartArray);
        HashSet<Object> hashSet = new LinkedHashSet<>(Arrays.asList(smartArray.toArray()));
        this.array = hashSet.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filter all distinct elements out";
    }
}
