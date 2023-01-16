package chapter1.section2.exercise;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.princeton.cs.algs4.StdOut;

public class Exercise12 {
    public static void main(String[] args) {
        Exercise12 smartDate = new Exercise12(2022, 9, 20);
        StdOut.println(smartDate.dayOfWeek());
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
        return year() + "/" + month() + "/" + day();
    }

    public Exercise12(int year, int month, int day) {
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

    public String dayOfWeek() {
        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        Calendar calendar = Calendar.getInstance();
        try {
            var date = new SimpleDateFormat("yyyy/MM/dd").parse(this.toString());
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return days[dayOfWeek - 1];
    }
}
