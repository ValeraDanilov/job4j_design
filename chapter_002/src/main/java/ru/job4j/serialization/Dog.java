package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "dog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dog {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;
    private SerialNumber number;

    @XmlElementWrapper(name = "visits")
    @XmlElement(name = "visit")
    private String[] visit;

    public Dog() {
    }

    public Dog(boolean sex, int age, String name, SerialNumber number, String... visit) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.number = number;
        this.visit = visit;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "sex=" + sex +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", visit=" + Arrays.toString(visit) +
                ", number=" + number +
                '}';
    }
}
