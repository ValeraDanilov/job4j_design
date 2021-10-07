package ru.job4j.lsp;

import java.util.List;

public interface ParkingCars {

    boolean park(Car car);
    List<Car> getCars();
}
