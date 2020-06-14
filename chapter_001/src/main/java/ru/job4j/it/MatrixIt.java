package ru.job4j.it;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;
    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (data.length > row) {
            if (data[row].length != 0) {
                if (column == data[row].length) {
                    column = 0;
                    row++;
                }
                result = true;
                break;
            }
            row++;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row].length == 0 ? ++row : data[row][column++];
    }
}