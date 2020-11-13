package ru.job4j.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MailTest {

    @Before
    public void setUp() {
        System.out.println("Before method");
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }

    @Test
    public void whenGropingUsers() {
        Map<String, User> map = new LinkedHashMap<>();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();

        user1.add("xxx@ya.ru");
        user1.add("foo@gmail.com");
        user1.add("lol@mail.ru");

        user2.add("ups@pisem.net");
        user2.add("foo@gmail.com");

        user3.add("vasya@pupkin.com");
        user3.add("xyz@pisem.net");

        user4.add("aaa@bbb.ru");
        user4.add("ups@pisem.net");

        user5.add("xyz@pisem.net");

        map.put("User - 1", user1);
        map.put("User - 2", user2);
        map.put("User - 3", user3);
        map.put("User - 4", user4);
        map.put("User - 5", user5);
        assertThat(new Mail().checkEmailUser(map).toString(), is("{User - 1={email=[aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com]," +
                                                            " User - 3={email=[vasya@pupkin.com, xyz@pisem.net]}"));
    }

    @Test
    public void whenGropingUser() {
        Map<String, User> map = new LinkedHashMap<>();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();

        user1.add("xxx@ya.ru");
        user1.add("foo@gmail.com");
        user1.add("lol@mail.ru");

        user2.add("ups@pisem.net");
        user2.add("foo@gmail.com");

        user3.add("vasya@pupkin.com");
        user3.add("xyz@pisem.net");

        user4.add("aaa@bbb.ru");
        user4.add("ups@pisem.net");

        user5.add("xyz@pisem.ru");

        map.put("User - 1", user1);
        map.put("User - 2", user2);
        map.put("User - 3", user3);
        map.put("User - 4", user4);
        map.put("User - 5", user5);
        assertThat(new Mail().checkEmailUser(map).toString(), is("{User - 1={email=[aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com]," +
                                                                        " User - 3={email=[vasya@pupkin.com, xyz@pisem.net], User - 5={email=[xyz@pisem.ru]}"));
    }
}
