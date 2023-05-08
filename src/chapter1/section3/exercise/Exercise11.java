package chapter1.section3.exercise;

import chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise11 {

    public static void main(String[] args) {
        String postfixExpression = "1 2 + 4 2 / *";
        int value = evaluatePostfix(postfixExpression);
        StdOut.println("Evaluate value: " + value);
        StdOut.println("Expected value: 6");
    }

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> operands = new Stack<>();
        String[] inputValues = postfix.split("\\s");
        for (String s : inputValues) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int operand2 = operands.pop();
                int operand1 = operands.pop();
                int result = switch (s) {
                    case "+" -> operand1 + operand2;
                    case "-" -> operand1 - operand2;
                    case "*" -> operand1 * operand2;
                    default -> operand1 / operand2;
                };
                operands.push(result);
            } else {
                operands.push(Integer.parseInt(s));
            }
        }
        return operands.pop();
    }
}
