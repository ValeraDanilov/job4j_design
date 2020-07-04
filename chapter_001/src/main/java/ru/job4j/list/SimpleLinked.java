package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinked<T> implements Iterable<T> {
    private int modCount = 0;
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public SimpleLinked() {
        this.last = new Node<T>(null, first,null);
        this.first = new Node<T>(null,null, last);
    }

    public void add(T model) {
        Node<T> node = last;
        node.item = model;
        last = new Node<T>(null, node, null);
        node.next = last;
        size++;
        modCount++;
    }

    public T get(int position) {
        Objects.checkIndex(position, size);
        Node<T> result = first;
            for(int index = 0; index <= position; index++) {
                result = result.next;
            }
        return result.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            Node<T> node = first;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node.next != last;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                node = node.next;
                return node.item;
            }
        };
    }

    private class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
