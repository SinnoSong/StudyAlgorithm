package chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise18 {
    public static void main(String[] args) {
        StdOut.println(mystery(2, 25));
        StdOut.println(mystery(3, 11));
        StdOut.println(mysteryV2(2, 25));
        StdOut.println(mysteryV2(3, 11));
    }

    /**
     * computes a * b
     * 
     * @param a
     * @param b
     * @return a * b
     */
    public static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    /**
     * computes a ^ b
     * 
     * @param a
     * @param b
     * @return a ^ b
     */
    public static int mysteryV2(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return mysteryV2(a * a, b / 2);
        return mysteryV2(a * a, b / 2) * a;
    }
}
