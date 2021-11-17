package ru.job4j.ispMenu;

import java.util.function.Predicate;

public class HubMenu implements Hub {

    private final Element menu = new ElementMenu();

    @Override
    public boolean add(String parentName, String childName, Action action) {
        Element res = returnChildElementMenu(this.menu, parentName);
        if (res == null) {
            return false;
        }
        res.add(new ElementMenu(childName, action));
        return true;
    }

    @Override
    public boolean deleteElementMenu(String elementMenu) {
        Element element = returnParentElementMenu(this.menu, elementMenu);
        if (element == null) {
            return false;
        }
        element.getElement().removeIf(a -> a.getName().equals(elementMenu));
        return true;
    }

    @Override
    public boolean replaceMenuItem(String oldName, String newName) {
        Element result = returnChildElementMenu(this.menu, oldName);
        if (result == null) {
            return false;
        }
        result.setName(newName);
        return true;
    }

    @Override
    public Action action(String elementMenu) {
        Element element = returnChildElementMenu(this.menu, elementMenu);
        if (element == null) {
            throw new NullPointerException();
        }
        return element.getAction();
    }

    @Override
    public String printMenu() {
        return createMenu(this.menu, "");
    }

    private Element returnChildElementMenu(Element elements, String el) {
        return returnElementMenu(elements, el, a -> a.getName().equals(el));
    }

    private Element returnParentElementMenu(Element elements, String el) {
        return returnElementMenu(elements, el, a -> a.getElement().stream().filter(b -> b.getName().equals(el)).count() == 1);
    }

    private Element returnElementMenu(Element elements, String el, Predicate<Element> predicate) {
        Element res = null;
        if (predicate.test(elements)) {
            return elements;
        }
        for (Element name : elements.getElement()) {
            res = returnElementMenu(name, el, predicate);
            if (res != null) {
                break;
            }
        }
        return res;
    }

    private String createMenu(Element elements, String write) {
        StringBuilder writeMenu = new StringBuilder();
        for (Element element : elements.getElement()) {
            writeMenu.append(write).append(" ").append(element.getName()).append(System.lineSeparator());
            writeMenu.append(createMenu(element, write + "--"));
        }
        return writeMenu.toString();
    }
}
