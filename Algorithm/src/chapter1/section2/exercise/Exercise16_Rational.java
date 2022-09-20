package chapter1.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise16_Rational {

    private class Rational {
        private long numerator;
        private long denominator;

        public Rational(int numerator, int denominator) {
            if (denominator == 0) {
                throw new RuntimeException("Denominator cannot be 0");
            }

            this.numerator = numerator;
            this.denominator = denominator;

            int gcd = gcd(numerator, denominator);
            this.numerator /= gcd;
            this.denominator /= gcd;

            if (this.denominator < 0) {
                this.denominator = -1 * this.denominator;
                this.numerator = -1 * this.numerator;
            }
        }

        public int getNumerator() {
            return (int) numerator;
        }

        public int getDenominator() {
            return (int) denominator;
        }

        public Rational plus(Rational b) {
            int resultNumerator = this.getNumerator() * b.getDenominator()
                    + this.getDenominator() * b.getNumerator();
            int resultDenominator = (this.getDenominator() * b.getDenominator());
            return new Rational(resultNumerator, resultDenominator);
        }

        public Rational minus(Rational b) {
            int resultNumerator = (this.getNumerator() * b.getDenominator()
                    - b.getNumerator() * this.getDenominator());
            int resultDenominator = (this.getDenominator() * b.getDenominator());
            return new Rational(resultNumerator, resultDenominator);
        }

        public Rational times(Rational b) {
            int resultNumerator = (this.getNumerator() * b.getNumerator());
            int resultDenominator = (this.getDenominator() * b.getDenominator());
            return new Rational(resultNumerator, resultDenominator);
        }

        public Rational divides(Rational b) {
            return times(new Rational(b.getDenominator(), b.getNumerator()));
        }

        public boolean equals(Object x) {
            if (this == x) {
                return true;
            }
            if (x == null) {
                return false;
            }
            if (this.getClass() != x.getClass()) {
                return false;
            }

            Rational that = (Rational) x;
            if (this.getNumerator() != that.getNumerator()) {
                return false;
            }
            if (this.getDenominator() != that.getDenominator()) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.getNumerator() + "/" + this.getDenominator();
        }

        private int gcd(int numerator, int denominator) {
            if (denominator == 0) {
                return numerator;
            } else {
                return gcd(denominator, numerator % denominator);
            }
        }
    }

    public static void main(String[] args) {
        new Exercise16_Rational().test();
    }

    private void test() {
        Rational rational1 = new Rational(1, 4);
        Rational rational2 = new Rational(2, 3);

        Rational rationalPlus = rational1.plus(rational2);
        StdOut.println("Plus test: 1/4 + 2/3 = " + rationalPlus.numerator + "/" + rationalPlus.denominator
                + " Expected: 11/12");

        Rational rationalMinus = rational1.minus(rational2);
        StdOut.println("Minus test: 1/4 - 2/3 = " + rationalMinus.numerator + "/" + rationalMinus.denominator
                + " Expected: -5/12");

        Rational rationalTimes = rational1.times(rational2);
        StdOut.println("Times test: 1/4 * 2/3 = " + rationalTimes.numerator + "/" + rationalTimes.denominator
                + " Expected: 1/6");

        Rational rationalDividedBy = rational1.divides(rational2);
        StdOut.println(
                "Divided by test: 1/4 / 2/3 = " + rationalDividedBy.numerator + "/" + rationalDividedBy.denominator
                        + " Expected: 3/8");

        Rational equalRational1 = rational1;
        Rational equalRational2 = new Rational(rational1.getNumerator(), rational1.getDenominator());
        Rational nonEqualRational = new Rational(7, 8);
        StdOut.println("Equal test 1 = " + rational1.equals(equalRational1) + " Expected: true");
        StdOut.println("Equal test 2 = " + rational1.equals(equalRational2) + " Expected: true");
        StdOut.println("Equal test 3 = " + rational1.equals(nonEqualRational) + " Expected: false");

        StdOut.println("toString() test 1 = " + rational1 + " Expected: 1/4");
        StdOut.println("toString() test 2 = " + rational2 + " Expected: 2/3");
    }
}
