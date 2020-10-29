package ru.job4j.map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashMapTest {

    HashMap<Integer, String> map;

    @Before
    public void setUp() {
        System.out.println("Before method");
        this.map = new HashMap<>();
    }

    @After
    public void tearDown() {
        System.out.println("After method");
        this.map = null;
    }

    @Test
    public void whenAddNewElementFalse() {
        this.map.insert(1, "One");
        assertFalse(this.map.insert(17, "One"));
    }

    @Test
    public void whenAddNewElementTrue() {
        assertTrue(this.map.insert(1, "One"));
    }

    @Test
    public void whenAddNewNullElementFalse() {
        assertFalse(this.map.insert(null, "One"));
    }

    @Test
    public void whenAddNewElementInHashMapAndPrintConsole() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertThat(this.map.get(8), is("Eight"));
    }

    @Test
    public void whenHashMapIsGrow() {
        this.map.insert(1, "1");
        this.map.insert(2, "2");
        this.map.insert(3, "3");
        this.map.insert(4, "4");
        this.map.insert(5, "5");
        this.map.insert(6, "6");
        this.map.insert(7, "7");
        this.map.insert(8, "8");
        this.map.insert(9, "9");
        this.map.insert(10, "10");
        this.map.insert(11, "11");
        this.map.insert(12, "12");
        this.map.insert(13, "13");
        this.map.insert(14, "14");
        this.map.insert(15, "15");
        assertThat(this.map.pintHashTable(), is(32));
    }

    @Test
    public void whenAddNewElementInHashMapAndPrintConsoleNull() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertNull(this.map.get(null));
    }

    @Test
    public void whenAddNewElementInHashMapAndNotPrintConsole() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertNull(this.map.get(17));
    }

    @Test
    public void whenAddNewElementInHashMapAndNotPrintConsole5() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertNull(this.map.get(5));
    }

    @Test
    public void whenAddNewElementInHashMapAndNotDeleteNull() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertFalse(this.map.delete(null));
    }

    @Test
    public void whenAddNewElementInHashMapAndDeleteConsole() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertTrue(this.map.delete(8));
    }

    @Test
    public void whenAddNewElementInHashMapAndNotDeleteConsole5() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertFalse(this.map.delete(5));
    }

    @Test
    public void whenAddNewElementInHashMapAndNotDeleteConsole() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(8, "Eight");
        assertFalse(this.map.delete(17));
    }

    @Test
    public void whenAddNewElementInHashMapAndPrintIteratorConsole1To5() {
        this.map.insert(1, "One");
        this.map.insert(2, "Two");
        this.map.insert(3, "Three");
        this.map.insert(4, "Four");
        this.map.insert(5, "Fife");
        Iterator<String> it = this.map.iterator();
        assertThat(it.next(), is("One"));
        assertThat(it.next(), is("Two"));
        assertThat(it.next(), is("Three"));
        assertThat(it.next(), is("Four"));
        assertThat(it.next(), is("Fife"));
    }

    @Test
    public void whenAddNewElementInHashMapAndPrintIteratorConsole1To16() {
        map.insert(1, "One");
        map.insert(16, "Sixteen");
        Iterator<String> it = this.map.iterator();
        assertThat(it.next(), is("One"));
        assertThat(it.next(), is("Sixteen"));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenIteratorPrintNull() {
        Iterator<String> it = this.map.iterator();
        assertThat(it.next(), is("One"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        map.insert(5, "first");
        Iterator<String> it = map.iterator();
        map.insert(2, "second");
        it.next();
    }
}
