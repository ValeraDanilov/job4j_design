package ru.job4j.list;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;


public class SimpleStackTest {
    SimpleStack<Integer> stack;

    @Before
    public void before() {
        stack = new SimpleStack<>();
        System.out.println("Before method");
    }

    @After
    public void after() {
        stack = null;
        System.out.println("After method");
    }

    @Test
    public void whenPushThenPoll() {
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        stack.push(1);
        stack.pop();
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.pop(), is(1));

    }

    @Test(expected = NoSuchElementException.class)
    public void whenPoolReturnNoSuchElementException() {
        stack.push(1);
        stack.pop();
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPoolReturnNull() {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}