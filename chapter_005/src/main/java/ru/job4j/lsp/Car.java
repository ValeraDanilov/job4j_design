package ru.job4j.lsp;

public abstract class Car {

    private String brand;
    private int dimension;

    public Car(String brand, int dimension) {
        this.brand = brand;
        this.dimension = dimension;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", dimension=" + dimension +
                '}';
    }
}
