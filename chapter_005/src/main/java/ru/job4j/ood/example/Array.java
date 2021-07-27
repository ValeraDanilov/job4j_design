package ru.job4j.ood.example;

public interface Array {

    void sort();

    void print (Object[] element);
}

//Второй пример нарушения SRP у будущего класса должна быть только одна цель. Данные интерфейс реализует 2 цели вывод массива на экран, и его сортировка. Нужно создать 2 отдельных интерфейса один для сортировки, второй вывод.
