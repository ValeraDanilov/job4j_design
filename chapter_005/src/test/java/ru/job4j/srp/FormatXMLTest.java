package ru.job4j.srp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FormatXMLTest {

    @Before
    public void setUp() {
        System.out.println("Before method");
    }

    @After
    public void tearDown() {
        System.out.println("After method");
    }

    @Test
    public void whenObjectReportEngineConvertInXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        Employee workerSecond = new Employee("Ira", now, now, 2100);
        store.add(workerFirst);
        store.add(workerSecond);
        Report res = new FormatXML(store);
        String get = res.generate(em -> true);
        String[] cut = get.split("<");
        String check = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<employees>\n" +
                "    <employee>\n" +
                "        <" + cut[4] + "</fired>\n" +
                "        <" + cut[6] + "</hired>\n" +
                "        <name>Ivan</name>\n" +
                "        <salary>100.0</salary>\n" +
                "    </employee>\n" +
                "    <employee>\n" +
                "        <" + cut[14] + "</fired>\n" +
                "        <" + cut[16] + "</hired>\n" +
                "        <name>Ira</name>\n" +
                "        <salary>2100.0</salary>\n" +
                "    </employee>\n" +
                "</employees>\n";
        assertThat(res.generate(em -> true), is(check));
    }
}
