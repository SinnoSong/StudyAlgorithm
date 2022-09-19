package chapter1.section2.exercise;

import edu.princeton.cs.algs4.StdDraw;

public class Exercise10_VisualCounter {

    public static void main(String[] args) {
        var visualCounter = new Exercise10_VisualCounter(6, 4);

        visualCounter.increment();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.increment();
    }

    private int maxOperations;
    private int maxCounter;

    private int currentOperations;
    private int currentCounter;

    /**
     * 
     * @param n   maxOperations
     * @param max max counter abs
     */
    public Exercise10_VisualCounter(int n, int max) {
        maxOperations = n;
        maxCounter = Math.abs(max);

        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(0.015);
        StdDraw.setXscale(0, maxOperations);
        StdDraw.setYscale(-maxCounter - 3, maxCounter + 3);
    }

    private void increment() {
        if (currentOperations < maxOperations && currentCounter < maxCounter) {
            currentCounter++;
            currentOperations++;
            plotCounter();
        }
    }

    private void decrement() {
        if (currentOperations < maxOperations && (Math.abs(currentCounter) <= maxCounter)) {
            currentOperations++;
            currentCounter--;

            plotCounter();
        }
    }

    private void plotCounter() {
        StdDraw.point(currentOperations, currentCounter);
    }
}
