package chapter1.section2;

public class Date {

    private final int month;
    private final int year;
    private final int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

    @Override
    public boolean equals(Object obj) {
        // 判断引用是否相等
        if (this == obj) {
            return true;
        }
        // 判断是否为空
        if (obj == null) {
            return false;
        }
        // 判断类型是否相同
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Date that = (Date) obj;
        if (this.getYear() != that.getYear()) {
            return false;
        }
        if (this.getMonth() != that.getMonth()) {
            return false;
        }
        if (this.getDay() != that.getDay()) {
            return false;
        }
        return true;
    }
}
