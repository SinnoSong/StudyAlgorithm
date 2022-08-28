package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class StdOutTest {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        // 3.00009
        StdOut.printf("%.5f\n", t);
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        // 499500
        StdOut.println(sum);
        // 重新设置sum 为0
        sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        // 10000
        System.out.println(sum);
    }

    /**
     * 前2个值为后一个值
     */
    public static void name() {
        int f = 0;
        int g = 1;
        for (int i = 0; i < 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
