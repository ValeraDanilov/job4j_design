package ru.job4j.serialization;
import org.json.JSONObject;
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

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String[] getVisit() {
        return visit;
    }

    public SerialNumber getNumber() {
        return number;
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

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", cat.isSex());
        jsonObject.put("age", cat.getAge());
        jsonObject.put("name", cat.getName());
        jsonObject.put("visit", cat.getVisit());
        jsonObject.put("number", cat.getNumber().getNumber());

       System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(cat).toString());
    }
}
