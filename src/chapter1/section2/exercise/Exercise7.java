package chapter1.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise7 {
    public static void main(String[] args) {
        var str = "test";
        StdOut.println(mystery(str));
    }

    private static String mystery(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        var a = s.substring(0, n / 2);
        var b = s.substring(n / 2, n);
        return mystery(b) + mystery(a);
    }
}
