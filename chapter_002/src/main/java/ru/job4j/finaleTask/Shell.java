package ru.job4j.finaleTask;

import java.util.LinkedList;
import java.util.List;

public class Shell {

    private List<String> box = new LinkedList<>();
    private int index;
    {
        this.box.add("/");
    }

    public void cd(String path) {
        if (path.endsWith("..") || path.equals("/")) {
            index = 0;
        } else {
            String prev = this.box.get(index++);
            String value = !prev.equals("/") ? prev + this.box.get(0) + path : this.box.get(0) + path;
            this.box.add(value);
        }
    }

    public String pwd() {
        return box.get(index);
    }
}
