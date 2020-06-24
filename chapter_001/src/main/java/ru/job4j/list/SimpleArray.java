package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[0];
    private int index = 0;
    private int modCount = 0;

    public void add(T model) {
        checkContainer(container, index);
        modCount++;
        this.container[index++] = model;
    }

    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) container[position];
    }

    private void checkContainer(Object[] objects, int position) {
        if (objects.length == position) {
            container = Arrays.copyOf(container, index + 10);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new  Iterator<T>() {
            private int iterIndex = 0;
            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
               if (expectedModCount != modCount) {
                   throw new ConcurrentModificationException();
               }
                return iterIndex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[iterIndex++];
            }
        };
    }
}
