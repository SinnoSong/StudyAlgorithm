package chapter1.section2.exercise;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

public class Exercise13 {
    private final String who;
    private final Date when;
    private final double amount;

    public Exercise13(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Date getWhen() {
        return when;
    }

    public String getWho() {
        return who;
    }

    @Override
    public String toString() {
        return getWho() + " spent " + getAmount() + " on " + getWhen();
    }

    public static void main(String[] args) {
        Date date = new Date(8, 3, 2016);

        Exercise13 transaction = new Exercise13("Rene", date, 500);
        StdOut.println(transaction);
        StdOut.println("Expected: Rene spent 500.0 on 8/3/2016");
    }
}
