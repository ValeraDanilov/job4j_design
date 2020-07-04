package ru.job4j.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedTest {
    SimpleLinked<String> simple;

    @Before
    public void Before() {
        simple = new SimpleLinked<>();
        System.out.println("Before method");
    }
    @After
    public void After() {
        simple = null;
        System.out.println("After method");
    }

    @Test
    public void addThreeElementGetReturnFirstElement() {
        simple.add("test");
        simple.add("test1");
        simple.add("test2");
        String result = simple.get(1);
        assertThat(result, is("test1"));
    }

    @Test
    public void addThreeElementsReturnIteratorThreeElement() {
        simple.add("test");
        simple.add("test1");
        simple.add("test2");
        Iterator<String> it = simple.iterator();
        assertThat(it.next(), is("test"));
        assertThat(it.next(), is("test1"));
        assertThat(it.next(), is("test2"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whatIteratorReturnNoSuchElementException() {
        Iterator<String> it = simple.iterator();
        assertThat(it.next(), is("test"));
        assertThat(it.next(), is("test1"));
        assertThat(it.next(), is("test2"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whatIteratorReturnNoSuchConcurrentModificationException() {
        simple.add("test");
        simple.add("test1");
        Iterator<String> it = simple.iterator();
        assertThat(it.next(), is("test"));
        simple.add("test2");
        assertThat(it.next(), is("test1"));

    }

}