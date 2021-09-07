package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private Node<T> head;

    public T pop() {
        Node<T> temp = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        temp.next = null;
        return temp.value;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value, null);
        Node<T> temp = head;
        if (head == null) {
            head = node;
            return;
        }
        head = node;
        head.next = temp;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
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