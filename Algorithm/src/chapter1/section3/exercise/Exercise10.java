package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise10 {
    private static String infixToPostfix(String input) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] inputValues = input.split("\\s");
        for (String str : inputValues) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                operators.push(str);
            } else if (str.equals(")")) {
                String operator = operators.pop();
                var var2 = operands.pop();
                var var1 = operands.pop();
                operands.push(var1 + " " + var2 + " " + operator);
            } else {
                operands.push(str);
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        String infixExpression = "( ( 1 + 2 ) * ( 4 / 2 ) )";
        String postFixExpression = infixToPostfix(infixExpression);

        StdOut.println("Postfix expression: " + postFixExpression);
        StdOut.println("Expected: 1 2 + 4 2 / *");
    }
}
