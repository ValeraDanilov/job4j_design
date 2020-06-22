package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {

    @Test
    public void addNewElement() {
        Store<User> mem = new MemStore<>();
        mem.add(new User("1"));
        User result = mem.findById("1");
        assertThat(result.getId(), is("1"));
    }

    @Test(expected = NullPointerException.class)
    public void addNewElementToNull() {
        Store<User> mem = new MemStore<>();
        mem.add(new User("1"));
        User result = mem.findById("2");
        assertThat(result.getId(), is("1"));
    }

    @Test
    public void replaceElementReturnTrue() {
        Store<User> mem = new MemStore<>();
        mem.add(new User("1"));
        mem.add(new User("3"));
        mem.add(new User("3"));
        boolean result = mem.replace("3", new User("2"));
        assertThat(result, is(true));
    }

    @Test
    public void replaceElementReturnFalse() {
        Store<User> mem = new MemStore<>();
        mem.add(new User("1"));
        mem.add(new User("3"));
        mem.add(new User("3"));
        boolean result = mem.replace("0", new User("2"));
        assertThat(result, is(false));
    }

    @Test
    public void deleteElementReturnTrue() {
        Store<User> mem = new MemStore<>();
        mem.add(new User("1"));
        mem.add(new User("3"));
        mem.add(new User("3"));
        boolean result = mem.delete("3");
        assertThat(result, is(true));
    }

    @Test
    public void deleteElementReturnFalse() {
        Store<User> mem = new MemStore<>();
        mem.add(new User("1"));
        mem.add(new User("3"));
        mem.add(new User("3"));
        boolean result = mem.delete("4");
        assertThat(result, is(false));
    }
}