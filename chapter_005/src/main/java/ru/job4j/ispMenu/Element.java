package ru.job4j.ispMenu;

import java.util.List;

public interface Element {
    void add(Element element);

    String getName();

    void setName(String name);

    List<Element> getElement();

    Action getAction();
}
