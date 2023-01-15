package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return minMax(value, (r, l) -> comparator.compare(r, l) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return minMax(value, (r, l) -> comparator.compare(r, l) < 0);
    }

    public <T> T minMax(List<T> value, BiPredicate<T, T> predicate) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("List of values is Empty");
        }
        T result = value.get(0);
        for (T l: value) {
            if(predicate.test(result, l)) {
                result = l;
            }
        }
        return result;
    }
}