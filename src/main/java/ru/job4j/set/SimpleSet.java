package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        } else {
            set.add(value);
            return true;
        }
    }

    @Override
    public boolean contains(T value) {
        for (T item : set) {
            if (Objects.equals(item, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}