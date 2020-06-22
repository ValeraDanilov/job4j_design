package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void addNewElement() {
        Store<Role> mem = new RoleStore();
        mem.add(new Role("1"));
        Role result = mem.findById("1");
        assertThat(result.getId(), is("1"));
    }

    @Test(expected = NullPointerException.class)
    public void addNewElementNull() {
        Store<Role> mem = new RoleStore();
        mem.add(new Role("1"));
        Role result = mem.findById("2");
        assertThat(result.getId(), is("1"));
    }

    @Test
    public void replaceElementReturnTrue() {
        Store<Role> mem = new RoleStore();
        mem.add(new Role("1"));
        mem.add(new Role("3"));
        mem.add(new Role("3"));
        boolean result = mem.replace("3", new Role("2"));
        assertThat(result, is(true));
    }

    @Test
    public void replaceElementReturnFalse() {
        Store<Role> mem = new RoleStore();
        mem.add(new Role("1"));
        mem.add(new Role("3"));
        mem.add(new Role("3"));
        boolean result = mem.replace("0", new Role("2"));
        assertThat(result, is(false));
    }

    @Test
    public void deleteElementReturnTrue() {
        Store<Role> mem = new RoleStore();
        mem.add(new Role("1"));
        mem.add(new Role("3"));
        mem.add(new Role("3"));
        boolean result = mem.delete("3");
        assertThat(result, is(true));
    }

    @Test
    public void deleteElementReturnFalse() {
        Store<Role> mem = new RoleStore();
        mem.add(new Role("1"));
        mem.add(new Role("3"));
        mem.add(new Role("3"));
        boolean result = mem.delete("4");
        assertThat(result, is(false));
    }
}