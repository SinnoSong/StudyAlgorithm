package chapter1.section1;

public class VarBetween0And1 {
    public static void main(String[] args) {
        double x = 0.23, y = 0.23;
        if (x > 0.0 && x < 1.0 && y > 0.0 && y < 1.0) {
            System.out.println("true");
        }
        System.out.println("false");
    }
}
