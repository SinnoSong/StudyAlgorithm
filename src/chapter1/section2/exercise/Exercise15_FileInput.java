package chapter1.section2.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise15_FileInput {
    private static final String filePath = "/home/sinno/repo/StudyAlgorithm/Algorithm/src/chapter1/section2/exercise/intsFile.txt";

    public static void main(String[] args) {
        int[] ints = readInts(filePath);
        for (int i : ints) {
            StdOut.println(i);
        }
    }

    private static int[] readInts(String name) {
        var in = new In(name);
        String inputString = in.readAll();
        var array = inputString.split("\\s+");
        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ints[i] = Integer.parseInt(array[i]);
        }
        return ints;
    }
}
