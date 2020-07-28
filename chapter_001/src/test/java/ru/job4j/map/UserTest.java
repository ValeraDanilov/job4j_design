package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void addUser() {
        User user = new User("Ira", 2, new GregorianCalendar(1987, Calendar.NOVEMBER,11));
        assertThat(user.toString(), is(new User("Ira", 2, new GregorianCalendar(1987, Calendar.NOVEMBER,11)).toString()));
    }
}
