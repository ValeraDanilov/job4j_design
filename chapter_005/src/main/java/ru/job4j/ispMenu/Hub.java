package ru.job4j.ispMenu;

public interface Hub {

    boolean add(String parentName, String childName, Action action);

    boolean deleteElementMenu(String elementMenu);

    boolean replaceMenuItem(String parentName, String childName);

    Action action(String elementMenu);

    String printMenu();
}
