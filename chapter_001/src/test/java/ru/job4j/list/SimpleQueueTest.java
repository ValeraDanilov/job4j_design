package ru.job4j.list;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SimpleQueueTest {
    SimpleQueue<Integer> queue;

     @Before
     public void before() {
         queue = new SimpleQueue<>();
         System.out.println("Before method");
     }

     @After
     public void after() {
         queue = null;
         System.out.println("After method");
     }

    @Test
    public void whenPushPoll() {
        queue.push(1);
        int rsl = queue.poll();
        assertThat(rsl, is(1));
    }

    @Test
    public void when2PushPoll() {
        queue.push(1);
        queue.push(2);
        int rsl = queue.poll();
        assertThat(rsl, is(1));
    }

    @Test
    public void when2PushPollPushPoll() {
        queue.push(1);
        queue.poll();
        queue.push(2);
        int rsl = queue.poll();
        assertThat(rsl, is(2));
    }

    @Test
    public void whenOutNull() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        queue.push(4);
        assertThat(queue.poll(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyPoll() {
        queue.poll();
    }
}