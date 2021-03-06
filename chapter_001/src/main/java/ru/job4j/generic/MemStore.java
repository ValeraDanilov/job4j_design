package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }
    private int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < mem.size(); index++) {
            if (this.mem.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            this.mem.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            this.mem.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }
}