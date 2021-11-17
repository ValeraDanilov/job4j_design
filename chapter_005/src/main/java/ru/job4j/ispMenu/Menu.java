package ru.job4j.ispMenu;

public class Menu {

    public void actionMenu() {
        boolean toLoop = true;
        while (toLoop) {
            init();
            System.out.println("Choose:");
            String red = CreateMenu.reader();
            if (red != null && red.equals("0")) {
                toLoop = false;
                continue;
            }
            if (CreateMenu.getMAP().containsKey(red)) {
                CreateMenu.getMAP().get(red).run();
            } else {
                System.out.println("You entered the menu item name which does not exist");
            }
        }
    }

    private void init() {
        System.out.println("Menu");
        System.out.println("1. Create menu");
        System.out.println("2. Change menu");
        System.out.println("3. Delete the chosen menu item");
        System.out.println("4. Display the menu on the screen");
        System.out.println("5. Display action");
        System.out.println("0. Exit");
        System.out.println();
    }

    public static void main(String[] args) {
        new Menu().actionMenu();
    }
}
