package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size = 0;

    private int modCount = 0;

    public SimpleArrayList() {
        this.container = (T[]) new Object[10];
    }


    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

     public void increase() {
        container = Arrays.copyOf(container, container.length * 2);
         }

    @Override
    public void add(T value) {
        if (size >= container.length) {
            increase();
        }
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T oldValue;
        Objects.checkIndex(index, size);
        oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T t = container[index];
        System.arraycopy(container,
                index + 1,
                container,
                index,
                container.length - index - 1);
        container[size--] = null;
        return t;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int counter = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return counter < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[counter++];
            }

        };
    }
}
