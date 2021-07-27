package ru.job4j.ood;

import java.util.Random;

public class RandomNumber implements NumberGenerator<Integer> {

    @Override
    public Integer generate() {
        return new Random().nextInt();
    }
}
