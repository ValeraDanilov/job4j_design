package ru.job4j.ood;

import java.util.List;

public class PrintNumber implements Output{

    @Override
    public void print(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }
}
