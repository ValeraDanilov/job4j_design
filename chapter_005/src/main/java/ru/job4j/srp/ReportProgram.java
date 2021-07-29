package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportProgram implements Report {

    private Store store;

    public ReportProgram(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<head>Name; Hired; Fired; Salary;</head>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<body>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</body>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
