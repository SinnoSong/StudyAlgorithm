package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise15 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        int[] newArra = histogram(a, 5);
        StdOut.println(newArra);
        StdOut.println();
    }

    public static int[] histogram(int[] a, int m) {
        int[] result = new int[m];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < m) {
                result[a[i]]++;
            }
        }
        return result;
    }
}
