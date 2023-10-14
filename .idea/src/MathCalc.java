import java.util.Scanner;
import java.util.Stack;

/**
 * General Description
 * Implement your task and push to the public git repository.
 * Share the link with the mentor. Create a simple java class that will read data
 * from the console and will print results to console.
 * <p>
 * Task 5 (Calculator, Math Challenge)
 * Have the function MathChallenge(str) take the str parameter being passed and evaluate
 * the mathematical expression within it. For example, if str were "2+(3-1)*3"
 * the output should be 8. Another example: if str were "(2-0)(6/2)" the output should be 6.
 * There can be parenthesis within the string, so you must evaluate it properly according
 * to the rules of arithmetic. The string will contain the operators: +, -, /, *, (, and ).
 * If you have a string like this: #/#*# or #+#(#)/#, then evaluate from left to right.
 * So divide then multiply, and for the second one multiply, divide, then add.
 * The evaluations will be such that there will not be any decimal operations,
 * so you do not need to account for rounding and whatnot.
 * <p>
 * Examples
 * Input: "6*(4/2)+3*1"
 * Output: 15
 * <p>
 * <p>
 * Input: "6/3-1"
 * Output: 1
 */

public class MathCalc {
    public static void main(String[] args) {
        System.out.println("Enter a math expression to evaluate:");

        Scanner console = new Scanner(System.in);
        String expression = console.nextLine();

        if (!expression.isEmpty()) {
            int result = evaluateExpression(expression);
            System.out.println("Result: " + expression + "=" + result + "\n");
        } else {
            System.out.println("Expression can't be empty!");
        }

        String expression1 = "2+(3-1)*3";
        String expression2 = "(2-0)(6/2)";
        String expression3 = "6/3-1";

        int result1 = evaluateExpression(expression1);
        int result2 = evaluateExpression(expression2);
        int result3 = evaluateExpression(expression3);

        System.out.println(expression1 + "=" + result1); // Output should be 8
        System.out.println(expression2 + "=" + result2); // Output should be 6
        System.out.println(expression3 + "=" + result3); // Output should be 1

    }
    public static int evaluateExpression(String str) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char prev = (i != 0) ? str.charAt(i - 1) : ch;

            if (Character.isDigit(ch)) {
                int operand = ch - '0';
                operands.push(operand);
            } else if (ch == '(') {
                if (prev == ')' || Character.isDigit(prev)) operators.push('*');
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    calculateOperands(operands, operators);
                }
                operators.pop(); // Remove '('
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && priority(operators.peek()) >= priority(ch)) {
                    calculateOperands(operands, operators);
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            calculateOperands(operands, operators);
        }

        return operands.pop();
    }

    private static void calculateOperands(Stack<Integer> operands, Stack<Character> operators) {
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        char operator = operators.pop();
        operands.push(applyOperator(operand1, operand2, operator));
    }

    private static int applyOperator(int operand1, int operand2, char operator) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            default -> operand1 / operand2;
        };
    }
    private static int priority(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

}
