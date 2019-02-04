package MS;

import java.util.Stack;

public class SimplifyPath {

    /*
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
    path = "/a/../../b/../c//.//", => "/c"
    path = "/a//b////c/d//././/..", => "/a/b/c"
     */

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(path.length()>0 && path.charAt(path.length()-1) == '/'){
            path = path.substring(0,path.length()-1);
        }
        for (int i = 0; i < path.length(); i++) {
            System.out.println("sb="+sb);
            System.out.println("stack="+stack);
            if(i == path.length()-1){
                if(sb.toString().equals(".") && path.charAt(i) == '.'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else if(sb.toString().equals(".") && path.charAt(i) == '/'){
                    break;
                } else if(sb.toString().equals("..") && path.charAt(i) == '/'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else if(path.charAt(i) == '/'){
                    stack.push(sb.toString());
                } else if(sb.length() == 0 && path.charAt(i)=='.'){
                    break;
                } else {
                    sb.append(path.charAt(i));
                    stack.push(sb.toString());
                }
                break;
            }
            if (path.charAt(i) == '/' ) {
                if (sb.length() == 0) {
                    continue;
                } else if (sb.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    sb = new StringBuilder();
                } else if (sb.toString().equals(".")) {
                    sb = new StringBuilder();
                } else {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(path.charAt(i));
            }

        }

        Stack<String> helper = new Stack<>();

        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }

        StringBuilder sb2 = new StringBuilder();
        while (!helper.isEmpty()) {
            sb2.append('/');
            sb2.append(helper.pop());

        }
        if(sb2.length() == 0){
            sb2.append('/');
        }
        return sb2.toString();
    }
}
