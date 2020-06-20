package ru.job4j.it;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleListTest {
    class A {}
    class B extends A {}
    class C extends B {}
    @Test
    public void WhenCreateContainterShouldReturnTheSameType() {
        SimpleList<String> simpleList = new SimpleList<String>(2);
        simpleList.add("test");
        String value = simpleList.get(0);
        assertThat(value, is("test"));
    }

    @Test
    public void WhenTypeIntShouldReturnInt() {
        SimpleList<Integer> simpleList = new SimpleList<Integer>(2);
        simpleList.add(5);
        int value = simpleList.get(0);
        assertThat(value, is(5));
    }

//    public void wildTest() {
//        SimpleList<B> list = new SimpleList(10);
//       // list.add(new A());
//        list.add(new B());
//        list.add(new C());
//        print(list);
//        printUpper(list);
//        printLower(list);
//    }
//    public void print(SimpleList<?> list) {}
//    public void printUpper(SimpleList<? extends B> list) {}
//    public void printLower(SimpleList<? super B> list) {}
}