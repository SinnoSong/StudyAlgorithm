package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise16 {
    public static void main(String[] args) {
        String dateFilePath = args[0];
        Date[] dates = readAllDates(dateFilePath);
        for (Date date : dates) {
            StdOut.println(date);
        }
    }

    private static Date[] readAllDates(String dateFilePath) {
        In in = new In(dateFilePath);
        Queue<Date> queue = new Queue<>();

        while (!in.isEmpty()) {
            queue.enqueue(new Date(in.readString()));
        }

        int n = queue.size();
        Date[] dates = new Date[n];

        for (int i = 0; i < n; i++) {
            dates[i] = queue.dequeue();
        }
        return dates;
    }
}
