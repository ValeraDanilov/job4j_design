package ru.job4j.inputOutput;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("./404.txt");
        System.out.println("size: " +  file.length() + System.lineSeparator() + file.getName());
    }
}
