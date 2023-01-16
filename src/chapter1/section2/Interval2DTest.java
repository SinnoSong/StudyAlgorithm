package chapter1.section2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

public class Interval2DTest {
    public static void main(String[] args) {
        // args = new String[] { "0.2", "0.5", "0.5", "0.6", "10000" };
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylow = Double.parseDouble(args[2]);
        double yhigh = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);

        Interval1D xInterval = new Interval1D(xlo, xhi);
        Interval1D yInterval = new Interval1D(ylow, yhigh);
        Interval2D box = new Interval2D(xInterval, yInterval);

        Counter counter = new Counter("hits");
        for (int i = 0; i < T; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) {
                counter.increment();
            } else {
                p.draw();
            }
        }

        StdOut.println(counter);
        StdOut.println(box.area());
    }
}
