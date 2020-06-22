package ru.job4j.generic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int modCount = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        modCount++;
        this.objects[index++] = value;
    }

    public T set(int position, T model) {
       Objects.checkIndex(position, index);
       this.objects[position] = model;
       modCount++;
       return (T) this.objects[position];
    }

    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) objects[position];
    }

    public T remove(int position) {
        modCount++;
        Objects.checkIndex(position, index);
        objects[position] = null;
        System.arraycopy(objects, position + 1, objects, position, index - position);
        index--;
        return (T) objects;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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
                return (T) objects[iterIndex++];
            }
        };
    }
}
