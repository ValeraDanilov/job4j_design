package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> soft = new SoftReference<>(value);
        cache.put(key, soft);
    }

    public V get(K key) throws IOException {
        if (key == null) {
            throw new NullPointerException();
        }
        V result = this.cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (result == null) {
            result = this.load(key);
            this.cache.put(key, new SoftReference<>(result));
        }
        return result;
    }

    protected abstract V load(K key) throws IOException;
}
