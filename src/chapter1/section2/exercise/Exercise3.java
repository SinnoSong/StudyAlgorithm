package chapter1.section2.exercise;

import java.util.HashMap;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise3 {
    private static HashMap<Interval2D, Interval1D[]> intervalMap = new HashMap<>();

    public static void main(String[] args) {
        int n = 10;
        double min = 0.1;
        double max = 0.9;

        Interval2D[] interval2ds = new Interval2D[n];

        drawAndCreateIntervals(interval2ds, min, max);

        int[] results = countIntervalIntersectionAndContains(interval2ds);
        StdOut.println("Pairs of intervals that intersect: " + results[0]);
        StdOut.println("Intervals contained in one another: " + results[1]);
    }

    private static int[] countIntervalIntersectionAndContains(Interval2D[] interval2ds) {
        int[] resluts = new int[2];
        int intersections = 0;
        int contains = 0;

        for (int i = 0; i < resluts.length - 1; i++) {
            for (int j = i + 1; j < resluts.length; j++) {
                if (interval2ds[i].intersects(interval2ds[j])) {
                    intersections++;
                }
                if (isContains(interval2ds[i], interval2ds[j])) {
                    contains++;
                }
            }
        }
        resluts[0] = intersections;
        resluts[1] = contains;
        return resluts;
    }

    private static void drawAndCreateIntervals(Interval2D[] interval2ds, double min, double max) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        for (int i = 0; i < interval2ds.length; i++) {
            Interval1D width = generateInterval1d(min, max);
            Interval1D height = generateInterval1d(min, max);
            Interval2D interval = new Interval2D(width, height);
            interval.draw();

            interval2ds[i] = interval;

            intervalMap.put(interval, new Interval1D[] { width, height });
        }
    }

    private static Interval1D generateInterval1d(double min, double max) {
        double firstValue = StdRandom.uniformDouble(min, max);
        double secondValue = StdRandom.uniformDouble(min, max);
        if (firstValue > secondValue) {
            double temp = firstValue;
            firstValue = secondValue;
            secondValue = temp;
        }

        Interval1D interval = new Interval1D(firstValue, secondValue);
        return interval;
    }

    private static boolean isContains(Interval2D interval1, Interval2D interval2) {
        boolean result = false;
        Interval1D[] intervalsFromInterval1 = intervalMap.get(interval1);
        Interval1D[] intervalsFromInterval2 = intervalMap.get(interval2);

        // Is interval1 contained in interval2 OR interval2 contained in interval1 ?
        if ((intervalsFromInterval1[0].min() > intervalsFromInterval2[0].min()
                && intervalsFromInterval1[0].max() < intervalsFromInterval2[0].max()
                && intervalsFromInterval1[1].min() > intervalsFromInterval2[1].min()
                && intervalsFromInterval1[1].max() < intervalsFromInterval2[1].max())
                ||
                (intervalsFromInterval2[0].min() > intervalsFromInterval1[0].min()
                        && intervalsFromInterval2[0].max() < intervalsFromInterval1[0].max()
                        && intervalsFromInterval2[1].min() > intervalsFromInterval1[1].min()
                        && intervalsFromInterval2[1].max() < intervalsFromInterval1[1].max())) {
            result = true;
        }
        return result;
    }
}
