package ru.job4j.ispMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CreateMenu {

    private static final Map<String, Runnable> MAP = new HashMap<>();

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String reader() {

        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static {

        Hub hub = new HubMenu();
        Action action = new PrintActions();
        MAP.put("1", () -> {
            System.out.println("Enter the name of the menu item and a sub item");
            hub.add(reader(), reader(), action);
        });
        MAP.put("2", () -> {
            System.out.println("Enter the menu item name which you want to change");
            hub.replaceMenuItem(reader(), reader());
        });
        MAP.put("3", () -> {
            System.out.println("Enter the menu item name which you want to delete");
            hub.deleteElementMenu(reader());
        });
        MAP.put("4", () -> System.out.println(hub.printMenu()));
        MAP.put("5", () -> {
            System.out.println("Enter the menu item name which you want to action");
            hub.action(reader());
        });
    }

    public static Map<String, Runnable> getMAP() {
        return MAP;
    }
}
