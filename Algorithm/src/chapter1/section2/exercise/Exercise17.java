package chapter1.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise17 {

    private class RationalNumbersRobust {
        private long numerator;
        private long denominator;

        private static final String ASSERT_AVOIDING_OVERFLOW_MESSAGE = "Operation would cause overflow";

        public RationalNumbersRobust(int numerator, int denominator) {
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

        public RationalNumbersRobust plus(RationalNumbersRobust b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;

            int resultNumerator = this.getNumerator() * b.getDenominator()
                    + this.getDenominator() * b.getNumerator();
            int resultDenominator = (this.getDenominator() * b.getDenominator());
            return new RationalNumbersRobust(resultNumerator, resultDenominator);
        }

        public RationalNumbersRobust minus(RationalNumbersRobust b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;

            int resultNumerator = (this.getNumerator() * b.getDenominator()
                    - b.getNumerator() * this.getDenominator());
            int resultDenominator = (this.getDenominator() * b.getDenominator());
            return new RationalNumbersRobust(resultNumerator, resultDenominator);
        }

        public RationalNumbersRobust times(RationalNumbersRobust b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;

            int resultNumerator = (this.getNumerator() * b.getNumerator());
            int resultDenominator = (this.getDenominator() * b.getDenominator());
            return new RationalNumbersRobust(resultNumerator, resultDenominator);
        }

        public RationalNumbersRobust divides(RationalNumbersRobust b) {
            return times(new RationalNumbersRobust(b.getDenominator(), b.getNumerator()));
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

            RationalNumbersRobust that = (RationalNumbersRobust) x;
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
        new Exercise17().testRationalNumbersRobust();
    }

    private void testRationalNumbersRobust() {
        RationalNumbersRobust rational1 = new RationalNumbersRobust(1, 4);
        RationalNumbersRobust rational2 = new RationalNumbersRobust(2, 3);

        RationalNumbersRobust rationalPlus = rational1.plus(rational2);
        StdOut.println("Plus test: 1/4 + 2/3 = " + rationalPlus.numerator + "/" +
                rationalPlus.denominator
                + " Expected: 11/12");

        RationalNumbersRobust rationalMinus = rational1.minus(rational2);
        StdOut.println("Minus test: 1/4 - 2/3 = " + rationalMinus.numerator + "/" +
                rationalMinus.denominator
                + " Expected: -5/12");

        RationalNumbersRobust rationalTimes = rational1.times(rational2);
        StdOut.println("Times test: 1/4 * 2/3 = " + rationalTimes.numerator + "/" +
                rationalTimes.denominator
                + " Expected: 1/6");

        RationalNumbersRobust rationalDividedBy = rational1.divides(rational2);
        StdOut.println(
                "Divided by test: 1/4 / 2/3 = " + rationalDividedBy.numerator + "/" +
                        rationalDividedBy.denominator
                        + " Expected: 3/8");

        RationalNumbersRobust equalRational1 = rational1;
        RationalNumbersRobust equalRational2 = new RationalNumbersRobust(rational1.getNumerator(),
                rational1.getDenominator());
        RationalNumbersRobust nonEqualRational = new RationalNumbersRobust(7, 8);
        StdOut.println("Equal test 1 = " + rational1.equals(equalRational1) + "Expected: true");
        StdOut.println("Equal test 2 = " + rational1.equals(equalRational2) + "Expected: true");
        StdOut.println("Equal test 3 = " + rational1.equals(nonEqualRational) + "Expected: false");

        StdOut.println("toString() test 1 = " + rational1 + " Expected: 1/4");
        StdOut.println("toString() test 2 = " + rational2 + " Expected: 2/3");

        // Would cause an overflow
        RationalNumbersRobust r1 = new RationalNumbersRobust(-2147483648, 1);
        RationalNumbersRobust r2 = new RationalNumbersRobust(-1, 1);
        r1.plus(r2);
    }
}
