package chapter1.section3.exercise;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise12 {
    private static Stack<String> copy(Stack<String> stack) {
        Stack<String> temp = new Stack<>();
        Stack<String> copy = new Stack<>();

        for (String s : stack) {
            temp.push(s);
        }
        for (String s : temp) {
            copy.push(s);
        }
        return copy;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("First Item");
        stack.push("Second Item");
        stack.push("Third Item");

        Stack<String> copy = copy(stack);
        stack.pop();
        stack.pop();

        for (String s : copy) {
            StdOut.println(s);
        }

        StdOut.println("\nExpected: " +
                "\nThird Item\n" +
                "Second Item\n" +
                "First Item");
    }
}
