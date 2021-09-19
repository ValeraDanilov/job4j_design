package ru.job4j.lsp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ControlQualityTest {

    private ControlQuality control;

    private Food bread;
    private Food milk;
    private Food cheese;
    private Food beer;

    private final int date = Calendar.getInstance().get(Calendar.DATE);
    private final int month = Calendar.getInstance().get(Calendar.MONTH);
    private final int year = Calendar.getInstance().get(Calendar.YEAR);

    @Before
    public void setUp() {
        System.out.println("Before method");
        this.control = new ControlQuality(List.of(new Shop(), new Trash(), new Warehouse()));
        this.bread = new Food("Bread", new GregorianCalendar(this.year, this.month, this.date - 1).getTime(), new GregorianCalendar(this.year, this.month, this.date + 1).getTime(), 120, 0);
        this.milk = new Food("Milk", new GregorianCalendar(this.year, this.month, this.date - 14).getTime(), new GregorianCalendar(this.year, this.month, this.date - 7).getTime(), 214, 0);
        this.cheese = new Food("Cheese", new GregorianCalendar(this.year, this.month - 4, this.date - 7).getTime(), new GregorianCalendar(this.year, this.month + 1, this.date + 1).getTime(), 1000, 0);
        this.beer = new Food("Beer", new GregorianCalendar(this.year, this.month, this.date - 5).getTime(), new GregorianCalendar(this.year, this.month + 1, this.date - 14).getTime(), 201, 0);
    }

    @After
    public void tearDown() {
        System.out.println("After method");
        this.control = null;
        this.bread = null;
        this.milk = null;
        this.cheese = null;
        this.beer = null;
    }

    @Test
    public void whenFoodInputInShop() {
        this.control.control(bread);
        String foods = this.control.control(beer).get(0).printRepository().toString();
        assertThat(foods, is(String.format("[Food[name=Bread, createDate=%s%s%s%s%s%s%s%s%s", new GregorianCalendar(this.year, this.month, this.date - 1).getTime(), ", expiryDate=", new GregorianCalendar(this.year, this.month, this.date + 1).getTime(), ", price=120.0, discount=0],", " Food[name=Beer, createDate=", new GregorianCalendar(this.year, this.month, this.date - 5).getTime(), ", expiryDate=", new GregorianCalendar(year, month + 1, this.date - 14).getTime(), ", price=201.0, discount=15]]")));
    }

    @Test
    public void whenFoodInputInTrash() {
        String foods = this.control.control(milk).get(1).printRepository().toString();
        assertThat(foods, is(String.format("[Food[name=Milk, createDate=%s%s%s%s", new GregorianCalendar(this.year, this.month, this.date - 14).getTime(), ", expiryDate=", new GregorianCalendar(this.year, this.month, this.date - 7).getTime(), ", price=214.0, discount=0]]")));
    }

    @Test
    public void whenFoodInputInWarehouse() {
        String foods = this.control.control(cheese).get(2).printRepository().toString();
        assertThat(foods, is(String.format("[Food[name=Cheese, createDate=%s%s%s%s", new GregorianCalendar(this.year, this.month - 4, this.date - 7).getTime(), ", expiryDate=", new GregorianCalendar(this.year, this.month + 1, this.date + 1).getTime(), ", price=1000.0, discount=0]]")));
    }
}
