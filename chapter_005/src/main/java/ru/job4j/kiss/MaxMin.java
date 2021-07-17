package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return (T)check(value, comparator)[0];
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return (T)check(value, comparator)[1];
    }

    private <T> Object[] check(List<T> value, Comparator<T> comparator) {
        T max = value.get(0);
        T min = value.get(0);
        for (T t: value) {
            if (comparator.compare(max, t) < 0) {
                max = t;
            } else if (comparator.compare(min, t) > 0){
                min = t;
            }
        }
        return new Object[]{max, min};
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2000000, 7000, 40, 600, -1, 99, 1000, 800, 99999);
        System.out.println(new MaxMin().max(list, Integer::compare));
        System.out.println(new MaxMin().min(list, Integer::compare));
    }
}
