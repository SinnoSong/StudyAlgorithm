package chapter1.section1;

public class BinaryStringTest {
    public static void main(String[] args) {
        String s = "";
        int N = 12321;
        for (int n = N; n > 0; n /= 2) {
            // 每次循环将除以2的余数设置为低位的二进制值
            s = (n % 2) + s;
        }
        System.out.println(s);
    }
}
