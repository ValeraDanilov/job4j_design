package ru.job4j.lsp;

public class TruckCar extends Car implements DimensionCar {

    public TruckCar(String brand, int dimension) {
        super(brand, dimension);
    }

    @Override
    public boolean checkDimensionCar(int dimension) {
        return false;
    }
}
