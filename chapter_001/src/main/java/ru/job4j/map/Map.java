package ru.job4j.map;

public interface Map<K, V> extends Iterable<V>{

    boolean insert(K key, V value);
    V get(K key);
    boolean delete(K key);
}
