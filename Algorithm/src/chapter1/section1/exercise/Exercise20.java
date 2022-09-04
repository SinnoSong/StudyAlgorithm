package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20 {
    public static void main(String[] args) {
        StdOut.println("ln(5!):" + InFactorial(5));
    }

    private static double InFactorial(int n) {
        if (n == 1) {
            return 0;
        }
        return Math.log(n) + InFactorial(n - 1);
    }
}
