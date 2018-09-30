import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens1));
        System.out.println(evalRPN(tokens2));
        System.out.println(evalRPN(tokens3));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperator(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                int int2 = Integer.parseInt(stack.pop());
                int int1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (tokens[i].equals("+")) {
                    result = int1 + int2;
                } else if (tokens[i].equals("-")) {
                    result = int1 - int2;
                } else if (tokens[i].equals("*")) {
                    result = int1 * int2;
                } else {
                    result = (int) (int1 / int2);
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static boolean isOperator(String s1) {
        if (s1.equals("+") || s1.equals("-") || s1.equals("*") || s1.equals("/")) {
            return true;
        }
        return false;
    }
}
