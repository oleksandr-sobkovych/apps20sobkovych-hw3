package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.SortDecorator;


public class SmartArrayApp {
    private static final int MINGPA = 4;
    private static final int YEAR = 2;

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray<Integer> sa = new BaseArray<>(integers);

        sa = new FilterDecorator<>(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator<>(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator<>(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student student = (Student) t;
                // in tests requires >=
                return student.getGPA() >= MINGPA && student.getYear() == YEAR;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(
                        ((Student) o2).getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student student = (Student) t;
                return student.getSurname() + " " + student.getName();
            }
        };

        SmartArray<Student> studentSmartArray = new BaseArray<>(students);
        studentSmartArray = new DistinctDecorator<>(
                new MapDecorator<>(
                        new SortDecorator<>(
                                new FilterDecorator<>(
                                        studentSmartArray,
                                        pr),
                                cmp),
                        func)
        );
        Object[] namesArray = studentSmartArray.toArray();
        return Arrays.copyOf(namesArray, namesArray.length, String[].class);
    }
}
