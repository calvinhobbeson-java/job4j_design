package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public T deleteFirst() {
        Node<T> temp = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        temp.next = null;
        size--;
        return temp.value;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        Node<T> temp = head;
        if (head == null) {
            head = node;
            size++;
            return;
        }
        head = node;
        head.next = temp;
        size++;
    }

    public boolean revert() {
        Node<T> previous = null;
        Node<T> current = head;
        if (size > 1) {
            while (current != null) {
                Node<T> next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
            return true;
        }
        return false;
    }


    @Override
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

