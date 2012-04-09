package ru.spbau.korovin.philosophers;

public class Philosopher implements Runnable {
    public static final int MAX_EAT_TIME = 20;
    public static final int MAX_SLEEP_TIME = 20;
    private final int position;
    private final Table table;

    public Philosopher(Table table, int position) {
        this.table = table;
        this.position = position;
    }

    public void run() {
        while (true) {
            synchronized (getLeft()) {
                takeLeft();
                synchronized (getRight()) {
                    takeRight();
                    eat();
                    releaseRight();
                }
                releaseLeft();
            }
            sleep();
        }
    }

    private void takeLeft() {
        System.out.println("P " + position + " takes " + leftIndex());
        table.takeFork(leftIndex());
    }

    private void takeRight() {
        System.out.println("P " + position + " takes " + rightIndex());
        table.takeFork(rightIndex());
    }

    private int leftIndex() {
        return position;
    }

    private int rightIndex() {
        int fork;
        if(position == table.getSize() - 1) {
            fork = 0;
        } else {
            fork = position + 1;
        }
        return fork;
    }

    private Fork getLeft() {
        System.out.println("P " + position + " tries to take " + leftIndex());
        return table.getFork(leftIndex());
    }

    private Fork getRight() {
        System.out.println("P " + position + " tries to take " + rightIndex());
        return table.getFork(rightIndex());
    }

    private void eat() {
        System.out.println("P " + position + " eating");
        try {
            Thread.sleep(Math.round(Math.random()* MAX_EAT_TIME));
        } catch (Exception e) {}
    }

    private void sleep() {
        System.out.println("P " + position + " sleeping");
        try {
            Thread.sleep(Math.round(Math.random()* MAX_SLEEP_TIME));
        } catch (Exception e) {}
    }

    private void releaseLeft() {
        System.out.println("P " + position + " releases " + leftIndex());
        table.putFork(leftIndex());
    }

    private void releaseRight() {
        System.out.println("P " + position + " releases " + rightIndex());
        table.putFork(rightIndex());
    }
}
