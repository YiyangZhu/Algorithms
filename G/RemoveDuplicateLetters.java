package G;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        if(s == null){
            return null;
        }

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        for(int i = 0 ;i < s.length(); i++){
            count[s.charAt(i)-'a']--;

            if(visited[s.charAt(i)-'a']){
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > s.charAt(i) && count[stack.peek()-'a']>0){
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            stack.push(s.charAt(i));
            visited[s.charAt(i)-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: stack){
            sb.append(ch);
        }
        return sb.toString();

    }
}