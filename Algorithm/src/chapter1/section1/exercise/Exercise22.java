package chapter1.section1.exercise;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class Exercise22 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int key = 2;
        Arrays.sort(arr);
        StdOut.println("Index:" + rank(key, arr, 0, arr.length - 1, 0));
    }

    private static int rank(int key, int[] arr, int low, int high, int depth) {
        if (depth != 0) {
            StdOut.println();
        }
        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }

        StdOut.print("low :" + low + " - high :" + high);

        if (low < high) {
            int mid = low + (high - low) / 2;
            if (key < arr[mid]) {
                return rank(key, arr, low, mid - 1, depth++);
            } else if (key > arr[mid]) {
                return rank(key, arr, mid + 1, high, depth++);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}
