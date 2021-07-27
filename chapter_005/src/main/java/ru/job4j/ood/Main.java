package ru.job4j.ood;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SimpleSequenceGenerator simple = new SimpleSequenceGenerator(new RandomNumber());
        List <Integer> list = simple.generate(5);
        new PrintNumber().print(list);
    }
}
