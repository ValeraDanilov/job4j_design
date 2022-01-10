package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> control(Food food) {
        for (Store store : this.stores) {
            store.check(food);
        }
        return this.stores;
    }

    public List<Store> resort() {
        List<Food> foods = new ArrayList<>();

        for (Store store : stores) {
            foods.addAll(store.printRepository());
            store.printRepository().clear();
        }

        for (Food food : foods) {
            control(food);
        }

        return stores;
    }
}
