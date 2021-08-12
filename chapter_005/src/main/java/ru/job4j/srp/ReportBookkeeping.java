package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportBookkeeping implements Report {

    private Store store;

    public ReportBookkeeping(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            int rub = (int) employee.getSalary();
            int cop = (int) Math.ceil(employee.getSalary()- rub);
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append("Rub: ").append(rub).append(" cop: ").append(cop).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
