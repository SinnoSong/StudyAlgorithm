package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        var str = "it was - the best - of times - - - it was - the - -";
        var split = str.split(" ");
        for (String e : split) {
            if (!e.equals("-")) {
                stack.push(e);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
