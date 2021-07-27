package ru.job4j.ood.example;

public interface APIManager {

    <T> void requestService(T t);

    <T> void gettingService(T t);
}

// Третий пример интерфейс который делает сериализацию и десериализацию. Нарушает SRP. Для них нужно реализовать два отдельных интерфейса.
