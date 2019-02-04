package MS;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != map.get(s.charAt(i))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}