package ru.job4j.set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    SimpleSet<Integer> set;

    @Before
    public void setUp() {
        set = new SimpleSet<>();
        System.out.println("before method");
    }

    @After
    public void tearDown() {
        set = null;
        System.out.println("After method");
    }

    @Test
    public void whenIteratorReturn1To3() {
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenSetDoesNotContainTheSameValues() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenSetReturnConcurrentModificationException() {
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        set.add(4);
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenSetReturnNoSuchElementException() {
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
    }
}