package ru.spbau.korovin.philosophers;

public class Fork {
    private boolean isFree;

    public Fork() {
        this.isFree = true;
    }

    public void take() {
        isFree = false;
    }

    public void put() {
        isFree = true;
    }
}
