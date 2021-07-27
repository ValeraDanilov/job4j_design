package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CinemaTest {

    @Before
    public void before() {
        System.out.println("Before method");
    }

    @After
    public void after() {
        System.out.println("After method");
    }

    @Ignore
    public void testBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

//    @Ignore(expected = Exception.class)
//    public void testBuyErrorDate() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        date.set(2020, Calendar.NOVEMBER, 33, 23, 0);
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//        assertThat(ticket, is(new Ticket3D()));
//    }

    @Ignore
    public void testBuyErrorSeat() {
        Account account = new AccountCinema();
        Account newAccount = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket newTicket = cinema.buy(account, 1, 1, date);
        Ticket ticket = cinema.buy(newAccount, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    public void testFindTrue() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    public void testFindFalse() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }
}
