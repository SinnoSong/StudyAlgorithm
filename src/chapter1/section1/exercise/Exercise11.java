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
        System.out.println("\t1\t2\t3");
        for (int i = 0; i < array.length; i++) {
            System.out.print("第" + i + "行：");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] ? "*\t" : " \t");
            }
            System.out.println();
        }
    }
}
