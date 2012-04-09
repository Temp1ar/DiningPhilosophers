import ru.spbau.korovin.philosophers.Philosopher;
import ru.spbau.korovin.philosophers.Table;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("How many philosophers do we have?");
        n = s.nextInt();

        Table table = new Table(n);
        for (int i = 0; i < n; i++) {
            Philosopher philosopher = new Philosopher(table, i);
            Thread p = new Thread(philosopher);
            p.start();
        }
    }
}
