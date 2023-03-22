package chapter1.section1.exercise;

public class Exercise9 {
    public static void main(String[] args) {
        String s = "";
        int N = 12321;
        for (int n = N; n > 0; n /= 2) {
            // 每次循环将除以2的余数设置为低位的二进制值
            s = (n % 2) + s;
        }
        System.out.println(s);
    }

    private static String intToBinary(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.insert(0, n % 2);
            n /= 2;
        }
        return result.toString();
    }
}
