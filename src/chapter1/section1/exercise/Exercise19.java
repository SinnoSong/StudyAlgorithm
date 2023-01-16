package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19 {
    public static void main(String[] args) {
        // for (int i = 0; i < 100; i++) {
        // StdOut.println(i + " " + F(i));
        // }
        for (int i = 0; i < 100; i++) {
            int[] arr;
            if (i == 0 || i == 1) {
                arr = new int[2];
            } else {
                arr = new int[i + 1];
            }

            arr[0] = 0;
            arr[1] = 1;
            StdOut.println(i + " - " + enhancedF(i, arr));
        }
    }

    public static long F(int N) {
        if (N == 0)
            return 0;
        if (N == 1) {
            return 1;
        }
        return F(N - 1) + F(N - 2);
    }

    public static long enhancedF(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
}
