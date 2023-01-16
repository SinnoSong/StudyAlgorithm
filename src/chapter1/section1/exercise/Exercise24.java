package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise24 {
    public static void main(String[] args) {
        var gcd = gcd(105, 23);
        StdOut.println("GCD 1:" + gcd);
    }

    public static int gcd(int p, int q) {
        StdOut.println("p:" + p + " - q:" + q);
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
