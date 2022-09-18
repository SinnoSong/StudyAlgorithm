package chapter1.section2.exercise;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise2 {
    public static void main(String[] args) {
        int n = 10;
        Interval1D[] intervals = new Interval1D[n];

        getIntervals(intervals);

        StdOut.println("Pairs that intersect:");
        printIntervalIntersections(intervals);
    }

    private static void printIntervalIntersections(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.printf("Interval 1 - Min: %.3f Max: %.3f \n", intervals[i].min(), intervals[i].max());
                    StdOut.printf("Interval 2 - Min: %.3f Max: %.3f \n\n", intervals[j].min(), intervals[j].max());
                }
            }
        }
    }

    private static void getIntervals(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            double firstValue = StdRandom.uniformDouble();
            double secondValue = StdRandom.uniformDouble();

            if (firstValue > secondValue) {
                double temp = firstValue;
                firstValue = secondValue;
                secondValue = temp;
            }
            intervals[i] = new Interval1D(firstValue, secondValue);
        }
    }

}
