package chapter1.section1;

public class ThreeNumEqual {
    public static void main(String[] args) {
        boolean result = args[0].equals(args[1]) && args[1].equals(args[2]);
        if (result) {
            System.out.println("equal");
        }
        System.out.println("not equal");
    }
}
