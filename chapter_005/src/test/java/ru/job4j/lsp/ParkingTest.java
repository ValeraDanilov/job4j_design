package ru.job4j.lsp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Before
    public void setUp() {
        System.out.println("Before method");
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }

    @Test
    public void whenPassengerGarsMakePark() {
        Car car = new PassengerCar("Audi");
        Parking parking = new Parking(10, 5);
        assertTrue(parking.park(car));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTruckGarsMakePark() {
        Car car = new TruckCar("Mercedes", 0);
        Parking parking = new Parking(1, 4);
        assertTrue(parking.park(car));
    }

    @Test
    public void whenTruckGarsMakeParkOnPassengerPlaceIsFalse() {
        Parking parking = new Parking(6, 0);
        Car car = new PassengerCar("Mercedes");
        parking.park(car);
        Car car1 = new PassengerCar("Mercedes");
        parking.park(car1);
        Car car2 = new PassengerCar("Mercedes");
        parking.park(car2);
        Car car3 = new TruckCar("Mercedes", 2);
        parking.park(car3);
        Car car4 = new PassengerCar("Mercedes");
        assertTrue(parking.park(car4));
    }

    @Test
    public void whenTruckGarsMakeParkOnPassengerPlaceIsTrue() {
        Parking parking = new Parking(4, 0);
        Car car = new PassengerCar("Mercedes");
        parking.park(car);
        Car carPassenger = new PassengerCar("Mercedes");
        parking.park(carPassenger);
        Car carTruck = new TruckCar("Mercedes", 2);
        assertTrue(parking.park(carTruck));
    }
}
