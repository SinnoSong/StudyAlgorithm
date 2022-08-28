package chapter1.section1;

public class PrintTest {
    public static void main(String[] args) {
        System.out.println('b');
        // 转换为数字
        System.out.println('b' + 'c');
        // 先转为数字，再将数字转为char
        System.out.println((char) ('a' + 4));
    }
}
