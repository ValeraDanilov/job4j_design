package ru.job4j.srp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportProgramTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Before method");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After method");
    }

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProgram(store);
        StringBuilder expect = new StringBuilder()
                .append("<head>Name; Hired; Fired; Salary;</head>")
                .append("<body>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</body>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
