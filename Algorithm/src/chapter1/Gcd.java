package chapter1;

public class Gcd {
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(p, r);
    }
}
