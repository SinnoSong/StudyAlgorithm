package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise27_BinomialDistribution {

    private static long count = 0;

    public static void main(String[] args) {
        // System.out.println(binomial(100, 50, 0.25));
        binomial2Start(100, 50, 0.25);
        StdOut.println(count);
    }

    private static double binomial(int N, int k, double p) {
        count++;
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    private static void binomial2Start(int N, int k, double p) {
        double[][] arr = new double[N + 1][k + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
        StdOut.print(binomial2(arr, N, k, p));
    }

    private static double binomial2(double[][] arr, int N, int k, double p) {
        count++;
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        if (arr[N][k] == -1) {
            arr[N][k] = (1 - p) * binomial2(arr, N - 1, k, p) + p * binomial2(arr, N - 1, k - 1, p);
        }

        return arr[N][k];
    }
}
