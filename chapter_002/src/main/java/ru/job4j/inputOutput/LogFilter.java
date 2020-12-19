package ru.job4j.inputOutput;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> lines = null;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            lines = in.lines().filter(value -> {
                var res = false;
                var tmp = value.split(" ");
                if (tmp[tmp.length - 2].equals("404")) {
                    res = true;
                }
                return res;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter pr = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String value: log) {
                pr.println(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = new LogFilter().filter("./log.txt");
        save(log, "./404.txt");
    }

    @Override
    public String toString() {
        return "LogFilter{}";
    }
}
