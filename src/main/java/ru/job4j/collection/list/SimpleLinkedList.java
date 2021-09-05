package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements List<E> {

    int size = 0;
    int modCount = 0;
    transient Node<E> first;
    transient Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
            size++;
            modCount++;
        }
    }

    @Override
    public E get(int index) {

        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private Node<E> counter = first;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return counter != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = counter.item;
                counter = counter.next;
                return value;
            }

        };
    }
}