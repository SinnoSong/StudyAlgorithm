package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {

    public static void main(String[] args) {
        Exercise4 exercise4 = new Exercise4();

        String textStreamInput = "[()]";
        StdOut.println("Is balanced " + textStreamInput + ": " + exercise4.isBalanced(textStreamInput)
                + " Expected: true");

        StdOut.println("Is balanced [()]{}{[()()]()}: " + exercise4.isBalanced("[()]{}{[()()]()}")
                + " Expected: true");
        StdOut.println("Is balanced [(]): " + exercise4.isBalanced("[(])") + " Expected: false");
        StdOut.println("Is balanced [(): " + exercise4.isBalanced("[()") + " Expected: false");
    }

    private boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        if (charArray.length % 2 == 1) {
            return false;
        }
        for (Character character : charArray) {
            if (character.equals('[') || character.equals('(') || character.equals('{')) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                var temp = stack.pop();
                if (temp.equals('[') && !character.equals(']') || temp.equals('(') && !character.equals(')')
                        || temp.equals('{') && !character.equals('}')) {
                    return false;
                }
            }
        }
        return true;
    }
}
