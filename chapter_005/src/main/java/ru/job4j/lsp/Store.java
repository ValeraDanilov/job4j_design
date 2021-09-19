package ru.job4j.lsp;

import java.util.List;

public interface Store {

    void check(Food food);
    List<Food> printRepository();
}
