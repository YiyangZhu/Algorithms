package MS;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println("result = " + longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        if (s == null || s.length() < 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                int[] a = {i, 0};
                stack.push(a);
            } else {
                if (stack.isEmpty() || stack.peek()[1] == 1) {
                    int[] a = {i, 1};
                    stack.push(a);
                } else {
                    stack.pop();
                    int currentLen = 0;
                    if (stack.isEmpty()) {
                        currentLen = i + 1;
                    } else {
                        currentLen = i - stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }
        return result;
    }
}
