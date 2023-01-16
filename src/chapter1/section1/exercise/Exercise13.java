package chapter1.section1.exercise;

public class Exercise13 {
    public static void main(String[] args) {
        int[][] arrayA = { { 11, 12, 13, 14, 15 }, { 21, 22, 23, 24, 25 }, { 31, 32, 33, 34, 35 },
                { 41, 42, 43, 44, 45 }, { 51, 52, 53, 54, 55 } };
        int[][] arrayB = new int[arrayA[0].length][arrayA.length];
        for (int i = 0; i < arrayB.length; i++) {
            for (int j = 0; j < arrayB[0].length; j++) {
                arrayB[i][j] = arrayA[j][i];
            }
        }
        for (int i = 0; i < arrayB.length; i++) {
            for (int j = 0; j < arrayB[0].length; j++) {
                System.out.println(arrayB[i][j]);
            }
        }
    }
}
