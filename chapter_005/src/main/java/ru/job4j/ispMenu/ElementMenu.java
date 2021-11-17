package ru.job4j.ispMenu;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ElementMenu implements Element {

    private String name;
    private final List<Element> element = new LinkedList<>();
    private final Action action;

    public ElementMenu() {
        this.name = "Menu";
        this.action = new PrintActions();
    }

    public ElementMenu(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    @Override
    public void add(Element element) {
        this.element.add(element);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Element> getElement() {
        return element;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementMenu that = (ElementMenu) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, element);
    }

    @Override
    public String toString() {
        return "ElementMenu{" +
                "name='" + name + '\'' +
                '}';
    }
}
