package ru.job4j.lsp;

public class Square extends Rectangle {

    @Override
    public int count (int height, int with) {
        return height * with;
    }
}

// 3-й стандартный пример с фигурами у квадрата должны быть все стороны равны что не скажешь про прямоугольник.
