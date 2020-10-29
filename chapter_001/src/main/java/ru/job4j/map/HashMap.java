package ru.job4j.map;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {

    private Node<K, V>[] hashTable;
    private int size;
    private float threshold;
    private static final float LOAD_FACTOR = 0.75f;
    private int modCount = 0;

    public HashMap() {
        this.hashTable = new Node[16];
        this.threshold = hashTable.length * LOAD_FACTOR;
    }

    public int pintHashTable() {
        return hashTable.length;
    }

    @Override
    public boolean insert(K key, V value) {
        if (this.size + 1 >= this.threshold) {
            int newSize = this.hashTable.length * 2;
            this.threshold = newSize * LOAD_FACTOR;
            arrayDoubling();
        }
        if (key != null) {
            Node<K, V> node = new Node<>(key, value);
            int index = hash(key);
            if (this.hashTable[index] == null) {
                this.hashTable[index] = node;
                this.size++;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void arrayDoubling() {
        Node<K, V>[] doublingNode = this.hashTable;
        this.hashTable = new Node[doublingNode.length * 2];
        this.size = 0;
        for (Node<K, V> node: doublingNode) {
            if (node != null) {
                insert(node.getKey(), node.getValue());
            }
        }
    }

    private int hash(K key) {
        int result = 31 * 17 + key.hashCode();
        return result % this.hashTable.length;
    }

    @Override
    public V get(K key) {
        if (key != null) {
            int index = hash(key);
            if (this.hashTable[index] != null && Objects.equals(this.hashTable[index].getKey(), key)) {
                 return this.hashTable[index].getValue();

            }
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        if (key != null) {
            int index = hash(key);
            if (this.hashTable[index] != null && Objects.equals(this.hashTable[index].getKey(), key)) {
                    this.hashTable[index] = null;
                    this.modCount++;
                    this.size--;
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private int count = 0;
            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
//                if (size == count) {
//                    return false;
//                }
                while (hashTable.length != index) {
                    if (hashTable[index] != null) {
                        count++;
                        return true;
                    }
                    index++;
                }
                return false;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return hashTable[index++].getValue();
            }
        };
    }

    private static class Node<K, V> {

        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Node<?, ?> node = (Node<?, ?>) o;
//            return Objects.equals(key, node.key) &&
//                    Objects.equals(value, node.value);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(key, value);
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "key=" + key +
//                    ", value=" + value +
//                    '}';
//        }
    }
}
