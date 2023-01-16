package chapter1.section1.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise21 {
    public static void main(String[] args) {
        StdOut.printf("%8s %7s %7s %7s", "Names", "Number1", "Number2", "Result\n");

        In in = new In();
        while (in.hasNextLine()) {
            var line = in.readLine();
            var values = line.split(" ");
            formattedPrint(values);
        }
    }

    private static void formattedPrint(String[] values) {
        StdOut.printf("%8s", values[0]);
        StdOut.printf("%8s", values[1]);
        StdOut.printf("%8s", values[2]);
        StdOut.printf("%7.3f \n", Double.parseDouble(values[1]) / Double.parseDouble(values[2]));
    }
}
