package G;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    static Set<Character> set = new HashSet<>();
    static Map<Character,Character> map = new HashMap<>();

    public static boolean isValid(String s) {
        if(s == null || s.length() < 1){
            return true;
        }
        constructSet();
        constructMap();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                if(!set.contains(ch)){
                    return false;
                } else {
                    stack.push(ch);
                }
            } else {
                if(!set.contains(ch)){
                    if(map.get(stack.peek()) == ch){
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(ch);
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }

    }

    public static void constructSet(){
        set.add('(');
        set.add('[');
        set.add('{');
    }

    public static void constructMap(){
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }
}
