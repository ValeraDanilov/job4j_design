package ru.job4j.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements ReportingHR {

    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public List<String> generate(Predicate<Employee> filter) {
        List<String> list = new ArrayList<>();
        List<Employee> employees = new ArrayList<>(store.findBy(filter));
        employees.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        StringBuilder text = new StringBuilder();
        for (Employee employee : employees) {
            text.append("Name; Hired; Fired; Salary;")
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        list.add(text.toString());
        return list;
    }
}
