package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise31_RandomConnections {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        draw(n, p);
    }

    private static void draw(int n, double p) {
        StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenRadius(0.015);

        double[][] array = new double[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = Math.cos(2 * Math.PI * i / n);
            array[i][1] = Math.sin(2 * Math.PI * i / n);
            StdDraw.point(array[i][0], array[i][1]);
        }

        StdDraw.setPenRadius();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(array[i][0], array[i][1], array[j][0], array[j][1]);
                }
            }
        }
    }
}
