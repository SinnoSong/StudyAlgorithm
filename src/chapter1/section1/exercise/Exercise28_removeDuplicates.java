package chapter1.section1.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.StdOut;

public class Exercise28_removeDuplicates {
    public static void main(String[] args) {
        int[] whiteList = { 1, 3, 4, 5, 5, 6, 6, 7, 7, 9 };
        int[] keys = { 1, 4, 6, 7, 8, 9 };
        Arrays.sort(whiteList);

        int[] compactWhitelist = removeDuplicates(whiteList);
        binarySearch(compactWhitelist, keys);
    }

    private static int[] removeDuplicates(int[] whitelist) {
        int[] newWhitelist = new int[whitelist.length];

        newWhitelist[0] = whitelist[0];
        int count = 0;

        for (int i = 1; i < whitelist.length; i++) {
            if (whitelist[i] != newWhitelist[count]) {
                count++;

                newWhitelist[count] = whitelist[i];
            }
        }
        count++;

        int[] compactNewWhitelist = new int[count];
        System.arraycopy(newWhitelist, 0, compactNewWhitelist, 0, count);

        return compactNewWhitelist;
    }

    private static int[] removeDuplicatesUseSet(int[] whiteList) {
        Set<Integer> set = new HashSet<>();
        for (int num : whiteList) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index] = num;
            index++;
        }
        return result;
    }

    private static void binarySearch(int[] whitelist, int[] keys) {

        int numbersCount = 0;

        for (int i = 0; i < keys.length; i++) {

            int index = rank(keys[i], whitelist, 0, whitelist.length - 1);

            if (index == -1) {
                if (numbersCount != 0) {
                    StdOut.print(", ");
                }

                StdOut.print(keys[i]);

                numbersCount++;
            }
        }

    }

    private static int rank(int key, int[] arr, int lo, int hi) {

        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < arr[mid]) {
                return rank(key, arr, lo, mid - 1);
            } else if (key > arr[mid]) {
                return rank(key, arr, mid + 1, hi);
            } else {
                return mid;
            }
        } else {
            return -1;
        }

    }
}
