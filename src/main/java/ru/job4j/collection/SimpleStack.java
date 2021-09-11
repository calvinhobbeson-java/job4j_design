package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private Node<T> head;

    public boolean isEmpty() {
        return linked.isEmpty();
    }

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
       linked.addFirst(value);
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}