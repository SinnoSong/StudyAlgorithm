package chapter1.section1;

public class GetLg {
    public static void main(String[] args) {
        System.out.println(lg(17));
    }

    public static int lg(int num) {
        int logInt = 0;
        while (num > 0) {
            logInt++;
            num /= 2;
        }
        return logInt - 1;
    }
}
