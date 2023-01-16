package chapter1.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {
    public static void main(String[] args) {
        var s1 = "abcdef";
        var s2 = "bcdefa";
        StdOut.println("Is circulat Shift :" + isCirulatShift(s1, s2));
    }

    private static boolean isCirulatShift(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }
}
