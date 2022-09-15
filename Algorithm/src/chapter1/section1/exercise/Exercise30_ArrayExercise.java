package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise30_ArrayExercise {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] array = createCoprimeArray(n);
        printArray(array);
    }

    private static void printArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                StdOut.printf("%6b", array[i][j]);
            }
            StdOut.println();
        }
    }

    private static boolean[][] createCoprimeArray(int n) {
        var array = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = isCoprime(i, j);
            }
        }

        return array;
    }

    private static boolean isCoprime(int i, int j) {
        if (i == j && i != 1) {
            return false;
        }

        if (i == 0 || j == 0) {
            return handleZero(i, j);
        }

        return gcd(i, j) == 1;
    }

    private static boolean handleZero(int i, int j) {
        return (i == 0 && j == 1) || (i == 0 && j == -1) || (j == 0 && i == 1) || (j == 0 && i == -1);
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return gcd(num2, num1 % num2);
        }
    }
}
