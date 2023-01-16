package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise29_EqualKeys {
    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 4, 5, 6, 6, 7, 7, 7, 8 };
        StdOut.println(rank(10, array));
        StdOut.println(count(7, array));
    }

    public static int rank(int key, int[] array) {
        int low = 0;
        int high = array.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (key > array[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }

    private static int greaterThanKey(int key, int[] array) {
        int low = 0;
        int high = array.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (key < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return array.length - high - 1;
    }

    public static int count(int key, int[] array) {
        int lessThanKey = rank(key, array);
        int greaterThanKey = greaterThanKey(key, array);
        return array.length - lessThanKey - greaterThanKey;
    }
}
