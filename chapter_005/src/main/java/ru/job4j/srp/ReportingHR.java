package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

public interface ReportingHR {
    List<String> generate(Predicate<Employee> filter);
}
