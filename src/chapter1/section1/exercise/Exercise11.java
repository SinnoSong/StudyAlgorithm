package chapter1.section1.exercise;

import java.util.Random;

public class Exercise11 {
    public static void main(String[] args) {
        boolean[][] array = new boolean[10][3];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextBoolean();
            }
        }
        System.out.println("\t\t1\t2\t3");
        for (boolean[] booleans : array) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean ? "*\t" : " \t");
            }
            System.out.println();
        }
    }
}
