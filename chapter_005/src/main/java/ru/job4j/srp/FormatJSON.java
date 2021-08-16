package ru.job4j.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class FormatJSON implements Report {

    private Store store;

    public FormatJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder().create().toJson(store.findBy(filter));
    }
}
