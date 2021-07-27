package ru.job4j.template;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Before
    public void setUp() {
        System.out.println("Before method");
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }

//    @Ignore(expected = NullPointerException.class)
//    public void produceReturnNullTest() {
//        Map<String, String> map = Map.of("age", "22");
//        String value = "I am ${name}";
//        Generator generator = new GeneratorValue();
//        String res = generator.produce(value, map);
//        assertThat(res, is("I am 22 years old"));
//    }

    @Ignore
    public void produceReturnNoTest() {
        Map<String, String> map = Map.of("name", "Ira","age", "22");
        String value = "I am ${name}";
        Generator generator = new GeneratorValue();
        String res = generator.produce(value, map);
        assertThat(res, is("I am 22 years old"));
        assertThat(map.size(), is(1));
    }

    @Ignore
    public void produceReturnValueTest() {
        Map<String, String> map = Map.of("name", "Ira");
        String value = "I am ${name}";
        Generator generator = new GeneratorValue();
        String res = generator.produce(value, map);
        assertThat(res, is("I am Ira"));
    }
}
