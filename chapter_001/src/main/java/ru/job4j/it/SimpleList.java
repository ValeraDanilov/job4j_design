package ru.job4j.it;

public class SimpleList<E> {
    private Object [] objects;
    private int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    public void add (E value) {
        this.objects[index++] = value;
    }

//    public <K> K print(K number) {
//        return number;
//    }

    public E get(int position) {
        return (E) this.objects[position];
     }
}
