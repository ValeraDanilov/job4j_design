package ru.job4j.dip;

import java.util.LinkedList;

public class Box {

    public String get(LinkedList<String> list) {
        return "";
    }
    // Нарушение dip если в будущем другой разработчик создаст базу новую и захочет передать в этот метод ArrayList то у него будет ошибка.
}
