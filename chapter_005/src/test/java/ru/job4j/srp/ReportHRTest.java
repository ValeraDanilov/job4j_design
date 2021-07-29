package ru.job4j.srp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportHRTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Before method");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After method");
    }

    @Test
    public void  whenOldGenerated() {
        MemStore store = new MemStore();
        Employee workerFirst = new Employee("Ivan",100);
        Employee workerSecond = new Employee("Roma",10);
        Employee workerThird = new Employee("Ira",99);
        store.add(workerFirst);
        store.add(workerSecond);
        store.add(workerThird);
        ReportingHR engine = new ReportHR(store);
        StringBuilder test = new StringBuilder();
        test.append("[Name; Hired; Fired; Salary;")
                .append("Ivan;100.0;")
                .append("Name; Hired; Fired; Salary;")
                .append("Ira;99.0;")
                .append("Name; Hired; Fired; Salary;")
                .append("Roma;10.0;]");
        assertThat(engine.generate(em -> true).toString(), is(test.toString()));
    }
}
