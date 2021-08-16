package ru.job4j.srp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FormatJSONTest {

    @Before
    public void setUp() {
        System.out.println("before method");
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }

    @Test
    public void whenObjectConvertInJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report res = new FormatJSON(store);
        String get = res.generate(em -> true);
        String check = "[{\"name\":\"Ivan\",\"" + get.substring(get.indexOf("hired"), get.indexOf("salary")) + "salary\":100.0}]";
        assertThat(res.generate(em -> true), is(check));
    }
}
