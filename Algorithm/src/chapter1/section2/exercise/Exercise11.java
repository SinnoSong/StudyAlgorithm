package chapter1.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise11 {
    public static void main(String[] args) {
        Exercise11 smartDate = new Exercise11(1983, 12, 32);
        StdOut.println(smartDate);
    }

    private final int month;
    private final int day;
    private final int year;

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public Exercise11(int year, int month, int day) {
        if (!isDateValid(year, month, day)) {
            throw new RuntimeException("Invalid date!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean isDateValid(int year, int month, int day) {
        boolean valid = true;
        int[] maxDaysPerMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > maxDaysPerMonth[month - 1]) {
            valid = false;
        }
        return valid;
    }
}
