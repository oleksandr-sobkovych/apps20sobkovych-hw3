package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator<T> extends SmartArrayDecorator<T> {

    public MapDecorator(SmartArray<T> smartArray, MyFunction func) {
        setArray(Arrays.stream(
                smartArray.toArray()).map(func::apply).toArray());
    }

    @Override
    public String operationDescription() {
        return "Map to values";
    }
}
