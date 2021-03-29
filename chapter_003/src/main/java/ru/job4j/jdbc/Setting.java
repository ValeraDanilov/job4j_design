package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setting {
    private final Properties pr = new Properties();

    public void load(InputStream io) {
        try {
            this.pr.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.pr.getProperty(key);
    }
}
