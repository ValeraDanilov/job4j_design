package ru.job4j.dip;

import java.util.ArrayList;

public interface Store {

    ArrayList<String> printAll();
    // Нарушение dip если хранилище в классе будет LinkedList оно не сможет работать для этого метода.
}
