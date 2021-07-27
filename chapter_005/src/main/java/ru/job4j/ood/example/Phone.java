package ru.job4j.ood.example;

public interface Phone {

    void dial(String phoneNumber);

    void disconnect();

    void send(String message);

    int receive();
}

// Первый пример нарушения SRP у будущего класса должна быть только одна цель. Данные интерфейс реализует 2 цели у телефона (звонить и отправлять смс). Данный интерфейс нужно разбить на два, 1 будет отвечать за звонки, второй отправлять принимать сообщение.
