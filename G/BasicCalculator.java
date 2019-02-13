package G;

import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        s = s.replaceAll(" ","");

        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        char[] charArray = s.toCharArray();

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(isOperator(s.charAt(i))){
                stack2.push(s.charAt(i));
            } else {
                stack1.push(Character.getNumericValue(s.charAt(i)));
            }
        }
        while(!stack1.isEmpty()){
            result = result + calculateOnce(stack1.pop(),stack1.pop(),stack2.pop());
        }
        return result;

    }

    public static int calculateOnce(int i, int j, char operator){
        if(operator == '+'){
            return i + j;
        } else if (operator == '-'){
            return i - j;
        }
        return 0;
    }

    public static boolean isOperator(char c){
        if(c == '+' || c== '-'){
            return  true;
        } else {
            return false;
        }
    }
}