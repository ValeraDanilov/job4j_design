package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Shop implements Store {

    private final List<Food> foods = new ArrayList<>();

    @Override
    public void check(Food food) {
        int first = (int) count(food.expiryDate().getTime(), food.createDate().getTime());
        int second = (int) count(new GregorianCalendar().getTime().getTime(), food.createDate().getTime());
        int a = second * 100 / first;
        if (100 - a >= 25 && 100 - a <= 75) {
            add(food);
        } else if (100 - a > 75) {
            add(new Food(food.name(), food.createDate(), food.expiryDate(), food.price(), 15));
        }
    }

    @Override
    public List<Food> printRepository() {
        return this.foods;
    }

    private long count(long first, long second) {
        long res = first - second;
        return TimeUnit.MILLISECONDS.toDays(res);
    }

    private void add(Food food) {
        this.foods.add(food);
    }
}
