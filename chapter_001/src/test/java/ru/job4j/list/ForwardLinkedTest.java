package ru.job4j.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ForwardLinkedTest {
    ForwardLinked<Integer> linked;

    @Before
    public void Before() {
        System.out.println("Before method");
        linked = new ForwardLinked<>();
    }
     @After
     public void After() {
         System.out.println("After method");
         linked = null;
     }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        linked.add(1);
        linked.add(2);
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whatAddThreeElementAndReturnThreeElement() {
        linked.add(1);
        linked.add(2);
        linked.add(3);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenAddThenIter() {
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenRevertReturnNoSuchElementException() {
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
    }
}
