package ru.job4j.lsp;

import java.util.List;

public class ControlQuality {

    List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> control(Food food) {
        for (Store store : this.stores) {
            store.check(food);
        }
        return this.stores;
    }
}
