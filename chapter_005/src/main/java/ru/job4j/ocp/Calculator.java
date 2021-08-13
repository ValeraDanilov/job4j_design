package ru.job4j.ocp;

public class Calculator {

    public int subtraction(int first, int second) {
        return first - second;
    }
}

// 2-й пример калькулятор, для создания других функций придется создавать дополнительные метод, по мне как легче будет создать абстрактный класс function с методом action и создать классы для каждого действия и наследоваться от класса function и реализовать методы action для каждой функции калькулятора.
