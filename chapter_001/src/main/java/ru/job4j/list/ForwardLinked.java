package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (isEmpty()) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    public T deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        Node<T> prev = head;
        if (node.next == null) {
            head = null;
        }
        while (node.next != null) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
        return node.value;
    }

    public void revert() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> node = new Node<>(head.value, null);
        Node<T> link = head;
           while (link.next != null) {
               link = link.next;
               node = new Node<>(link.value, node);
           }
           head = node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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
