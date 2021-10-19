package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingCars {

    private int limitPassengerCar;
    private int limitTruckCar;
    private List<Car> cars = new ArrayList<>();
    private int countTruckCar = 0;
    private int countPassengerCar = 0;

    public Parking(int limitPassengerCar, int limitTruckCar) {
        this.limitPassengerCar = limitPassengerCar;
        this.limitTruckCar = limitTruckCar;
    }

    @Override
    public boolean park(Car car) {

        boolean res = false;

        if (this.limitTruckCar > this.countTruckCar && car.getDimension() != 1) {
            this.cars.add(car);
            this.countTruckCar++;
            res = true;
        } else if ((this.limitPassengerCar - this.countPassengerCar) >= (car.getDimension())) {
            this.cars.add(car);
            this.countPassengerCar += car.getDimension();
            res = true;
        }
        return res;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
