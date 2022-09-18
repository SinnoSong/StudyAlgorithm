package chapter1.section2.exercise;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1 {
    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]); // 10
        int n = 10;
        Point2D[] point2ds = new Point2D[n];
        drawAndCreatePoints(point2ds);
        StdOut.printf("The shortest distance is: %.3f \n", calculateShortestDistance(point2ds));
    }

    private static Object calculateShortestDistance(Point2D[] point2ds) {
        double shortestDistance = Double.MAX_VALUE;
        double currentDistance;

        for (int i = 0; i < point2ds.length - 1; i++) {
            for (int j = i + 1; j < point2ds.length; j++) {
                currentDistance = point2ds[i].distanceTo(point2ds[j]);
                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                }
            }
        }
        return shortestDistance;
    }

    private static void drawAndCreatePoints(Point2D[] point2ds) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(0.015);

        for (int i = 0; i < point2ds.length; i++) {
            double pointX = StdRandom.uniformDouble();
            double pointY = StdRandom.uniformDouble();

            Point2D point = new Point2D(pointX, pointY);
            point.draw();

            point2ds[i] = point;
        }
    }

}
