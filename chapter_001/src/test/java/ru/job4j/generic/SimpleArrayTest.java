package ru.job4j.generic;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void CheckForAddingAnItem() {
        SimpleArray<Integer> simple = new SimpleArray<>(1);
        simple.add(10);
        int result = simple.get(0);
        assertThat(result, is(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void CheckForAddingForIndexOutOfBoundsException() {
        SimpleArray<Integer> simple = new SimpleArray<>(1);
        simple.add(10);
        int result = simple.get(1);
        assertThat(result, is(10));
    }

    @Test
    public void checkReplacementItem () {
        SimpleArray<String> simple = new SimpleArray<>(3);
        simple.add("test");
        simple.add("test1");
        simple.add("test2");
        String result = simple.set(1,"testOne");
        assertThat(result, is("testOne"));
    }

    @Test
    public void checkElementRemote() {
        SimpleArray<String> simple = new SimpleArray<>(4);
        simple.add("test");
        simple.add("test1");
        simple.add("test2");
        simple.remove(1);
        assertThat(simple.get(1), is("test2"));
    }

    @Test
    public void checkIterator1To3() {
        SimpleArray<String> simple = new SimpleArray<>(3);
        simple.add("test");
        simple.add("test1");
        simple.add("test2");
        assertThat(simple.iterator().hasNext(), is(true));
        assertThat(simple.iterator().hasNext(), is(true));

    }
    @Test(expected = ConcurrentModificationException.class)
    public void checkIteratorToConcurrentModificationException() {
        SimpleArray<String> simple = new SimpleArray<>(4);
        simple.add("test");
        simple.add("test1");
        simple.add("test2");
        simple.add("test3");
        Iterator<String> iterator = simple.iterator();
        assertThat(iterator.next(), is("test"));
        simple.set(1,"test4");
        assertThat(iterator.next(), is("test1"));
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.next(), is("test3"));
    }

    @Test
    public void checkIteratorFrom1To4() {
        SimpleArray<String> simple = new SimpleArray<>(4);
        simple.add("test");
        simple.add("test1");
        simple.add("test2");
        simple.add("test3");
        Iterator<String> iterator = simple.iterator();
        assertThat(iterator.next(), is("test"));
        assertThat(iterator.next(), is("test1"));
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.next(), is("test3"));
    }

    @Test(expected = NoSuchElementException.class)
    public void checkIteratorToNoSuchElementException() {
        SimpleArray<String> simple = new SimpleArray<>(0);
        Iterator<String> iterator = simple.iterator();
        assertThat(iterator.next(), is("test"));
    }
}