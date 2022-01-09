package ru.job4j.dip;

import java.util.ArrayList;

public class Shop {

    private ArrayList<String> box = new ArrayList<>();

    public ArrayList<String> getBox() {
        return box;
    }

    //Нарушение dip, если со временем другой разработчик создаст новый класс и там создаст LinkedList и попробует присвоить ему getBox(), то код не будет работать.
}
