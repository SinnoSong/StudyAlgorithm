package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {
    public static void main(String[] args) {
        var input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        StdOut.println(getInfixExpression(input));
    }

    private static String getInfixExpression(String input) {

        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] inputValues = input.split("\\s");
        for (String str : inputValues) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                operators.push(str);
            } else if (str.equals(")")) {
                String operator = operators.pop();
                var var1 = operands.pop();
                var var2 = operands.pop();
                operands.push("( " + var2 + operator + var1 + " )");
            } else {
                operands.push(str);
            }
        }
        return operands.pop();
    }

}
