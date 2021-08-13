package ru.job4j.ocp;

import java.util.List;

public class FactoryTV {

    private static class TV {

        public String functions() {
            return "connect internet";
        }

    }

    public static void main(String[] args) {
        List <TV> list = List.of(new TV(), new TV());
    }
}

// 1-й пример. У нас есть фабрика по созданию телевизоров с подключением к интернету, в уроке есть подобный пример где всё обошлось наследованием, я бы возможно лучше создал интерфейс TV с методом functions и при реализации уже указывал есть там функция подключение к инету или нет.
