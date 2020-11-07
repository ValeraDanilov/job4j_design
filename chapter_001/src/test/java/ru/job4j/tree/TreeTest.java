package ru.job4j.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {

    private Tree<Integer> tree;

    @Before
    public void setUp() {
        System.out.println("Before method");
        this.tree = new Tree<>(1);
    }

    @After
    public void tearDown() {
        System.out.println("After method");
        this.tree = null;
    }

    @Test
    public void when6ElFindLastThen6() {
        this.tree.add(1, 2);
        this.tree.add(1, 3);
        this.tree.add(1, 4);
        this.tree.add(4, 5);
        this.tree.add(5, 6);
        assertThat(tree.findBy(1).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        this.tree.add(1, 2);
        assertThat(tree.findBy(-1).isPresent(), is(false));
    }

    @Test
    public void whenParenFalseChildTry() {
        this.tree.add(1, 2);
        assertThat(tree.add(3, 5), is(false));
    }

    @Test
    public void whenParentTryChildFalse() {
        this.tree.add(1, 2);
        assertThat(tree.add(1, 2), is(false));
    }

    @Test
    public void when6ElFindLastThen61True() {
        this.tree.add(1, 2);
        this.tree.add(1, 4);
        this.tree.add(4, 5);
        this.tree.add(5, 6);
        assertTrue(tree.isBinary());
    }
    @Test
    public void when6ElFindLastThen61False() {
        this.tree.add(1, 2);
        this.tree.add(1, 3);
        this.tree.add(1, 4);
        assertFalse(tree.isBinary());
    }
}
