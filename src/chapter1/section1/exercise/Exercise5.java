package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise5 {
    public static void main(String[] args) {
        isStrictlyBetween0And1(1.12, 1.33);
        StdOut.println("Expected: false");

        isStrictlyBetween0And1(0.2, 1);
        StdOut.println("Expected: false");

        isStrictlyBetween0And1(0.5, 0.75);
        StdOut.println("Expected: true");
    }

    private static void isStrictlyBetween0And1(double x, double y) {
        if (x > 0.0 && x < 1.0 && y > 0.0 && y < 1.0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
