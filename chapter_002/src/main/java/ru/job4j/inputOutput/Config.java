package ru.job4j.inputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (String value = read.readLine(); value != null; value = read.readLine()) {
                if ((value.contains("=")) && (!value.startsWith("#"))) {
                    var cut = value.split("=");
                    this.values.put(cut[0], cut[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (this.values.get(key) != null) {
            return this.values.get(key);
        }
        throw new UnsupportedOperationException("Don't impl this method yet!");
    }
}
