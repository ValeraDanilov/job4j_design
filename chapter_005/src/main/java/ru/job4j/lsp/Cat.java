package ru.job4j.lsp;

public class Cat extends Animal {

    @Override
    public void run() throws Exception {
        throw new Exception();
    }
}

// 2-й пример нарушение метода подстановки ожидает вывода на экран а получает эксепшн.
