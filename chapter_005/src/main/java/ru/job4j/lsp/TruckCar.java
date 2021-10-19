package ru.job4j.lsp;

public class TruckCar extends Car {

    public TruckCar(String brand, int dimension) {
        super(brand, dimension);
        if (dimension < 2) {
            throw new IllegalArgumentException();
        }
    }
}
