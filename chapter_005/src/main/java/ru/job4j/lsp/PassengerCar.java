package ru.job4j.lsp;

public class PassengerCar extends Car {

    private final static int LIGHT_CAR_SIZE = 1;

    public PassengerCar(String brand) {
        super(brand, LIGHT_CAR_SIZE);
    }
}
