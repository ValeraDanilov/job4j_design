package ru.job4j.lsp;

public class PassengerCar extends Car implements DimensionCar {

    public PassengerCar(String brand, int dimension) {
        super(brand, dimension);
    }

    @Override
    public boolean checkDimensionCar(int dimension) {
        return false;
    }
}
