package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> array = new SimpleArray<T>();

    public void add(T value) {
        if (check(value)) {
            array.add(value);
        }
    }

    private boolean check(T value) {
        boolean result = true;
        for (T t : array) {
            if (Objects.equals(value, t)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
