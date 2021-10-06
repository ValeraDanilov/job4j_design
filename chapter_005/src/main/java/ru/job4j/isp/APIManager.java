package ru.job4j.isp;

public interface APIManager {

    <T> void requestService(T t);
    <T> void gettingService(T t);
}

// Второй пример - Так как принципы SRP и ISP тесно связаны между собой, то сюда можно добавить пример нарушения с SRP. Интерфейс который делает сериализацию и десериализацию. Нарушает SRP и ISP. Для них нужно реализовать два отдельных интерфейса.
