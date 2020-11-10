package ru.job4j.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Before
    public void setUp() {
        System.out.println("Before method");
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }

    @Test
    public void whenAddNewUser() {
        List<Analyze.User> users = List.of(
                new Analyze.User(1, "1"),
                new Analyze.User(2, "2"),
                new Analyze.User(3, "3"),
                new Analyze.User(4, "4"),
                new Analyze.User(5, "5"),
                new Analyze.User(6, "6"));
        assertThat(new Analyze().diff(new ArrayList<>(), users).added, is(6));
    }

    @Test
    public void whenChangeUser() {
        List<Analyze.User> users = List.of(
                new Analyze.User(1, "1"),
                new Analyze.User(2, "2"),
                new Analyze.User(3, "3"),
                new Analyze.User(4, "4"),
                new Analyze.User(5, "5"),
                new Analyze.User(6, "6"));

        List<Analyze.User> changeUsers = List.of(
                new Analyze.User(1, "0"),
                new Analyze.User(2, "1"),
                new Analyze.User(3, "3"),
                new Analyze.User(4, "4"),
                new Analyze.User(5, "4"),
                new Analyze.User(6, "6"));
        assertThat(new Analyze().diff(users, changeUsers).changed, is(3));
    }

    @Test
    public void whenAddNewUseThenChangeAndDelete() {
        List<Analyze.User> users = List.of(
                new Analyze.User(1, "1"),
                new Analyze.User(2, "2"),
                new Analyze.User(3, "3"),
                new Analyze.User(4, "4"));

        List<Analyze.User> changeUsers = List.of(
                new Analyze.User(1, "2"),
                new Analyze.User(2, "3"),
                new Analyze.User(3, "4"),
                new Analyze.User(5, "5"),
                new Analyze.User(6, "6"),
                new Analyze.User(7, "7"));
        assertThat(new Analyze().diff(users, changeUsers).toString(), is("Info{added = 3, changed = 3, deleted = 1}"));
    }
}