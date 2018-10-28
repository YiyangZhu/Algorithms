import java.util.Stack;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("stack="+stack);
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                if (j < s.length()) {
                    String current = s.substring(j, i+1).trim();
                    if(!current.equals("")){
                        stack.push(current);
                    }
                    j = i + 1;
                }
            }
        }
        System.out.println("stack="+stack);
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }
        return result.substring(0, result.length() - 1);
    }
}
