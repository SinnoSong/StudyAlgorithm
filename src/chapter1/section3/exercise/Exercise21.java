package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise21 {
    public static void main(String[] args) {
        Stack<String> linkedList = new Stack<>();
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");

        StdOut.println("Find B result: " + Exercise21.find(linkedList, "B") + " Expected: true");
        StdOut.println("Find Z result: " + Exercise21.find(linkedList, "Z") + " Expected: false");
    }

    private static boolean find(Stack<String> stack, String key) {
        for (var str : stack) {
            if (str.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
