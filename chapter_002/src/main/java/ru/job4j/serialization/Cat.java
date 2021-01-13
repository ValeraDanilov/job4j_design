package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Cat {

    private final boolean sex;
    private final int age;
    private final String name;
    private final String[] visit;
    private final SerialNumber number;

    public Cat(boolean sex, int age, String name, String[] visit, SerialNumber number) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.visit = visit;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "sex=" + sex +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", visit=" + Arrays.toString(visit) +
                ", number=" + number +
                '}';
    }

    public static void main(String[] args) {

        final Cat cat = new Cat(false, 3, "Мурзик", new String[]{"18.07.20"}, new SerialNumber("1055381"));

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(cat));

        String result = "{"
                + "\"sex\":false,"
                + "\"age\":3,"
                + "\"name\":Мурзик,"
                + "\"visit\":"
                + "[\"18.07.20\"]," +
                "\"number\":"
               + "{\"number\":\"1055381\"}" +
                "}";
        final Cat catResult = gson.fromJson(result, Cat.class);
        System.out.println(catResult);
    }
}
