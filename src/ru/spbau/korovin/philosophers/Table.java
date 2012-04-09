package ru.spbau.korovin.philosophers;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Fork> forks;
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public Table(int size) {
        forks = new ArrayList<Fork>();
        for (int i = 0; i < size; i++) {
            forks.add(new Fork());
        }
        this.size = size;
    }

    public void takeFork(int num) {
        forks.get(num).take();
    }

    public void putFork(int num) {
        forks.get(num).put();
    }

    public Fork getFork(int num) {
        return forks.get(num);
    }
}
