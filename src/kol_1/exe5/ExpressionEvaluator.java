package kol_1.exe5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '*') {
                applyOperation(stack, num, operation);
                num = 0;
                operation = c;
            }
        }

        applyOperation(stack, num, operation);

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private static void applyOperation(Stack<Integer> stack, int num, char operation) {
        if (operation == '+') {
            stack.push(num);
        } else if (operation == '*') {
            stack.push(stack.pop() * num);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}
