package ru.job4j.serialization;

public class SerialNumber {

    private final String number;

    public SerialNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "SerialNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}
