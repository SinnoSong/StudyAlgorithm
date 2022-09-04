package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise26_SortingThreeNumbers {
    public static void main(String[] args) {
        var a = 103;
        var b = 23;
        var c = 239;
        var t = 0;

        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        StdOut.println("a: " + a);
        StdOut.println("b: " + b);
        StdOut.println("c: " + c);
    }
}