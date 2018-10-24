import java.util.Stack;

public class ImplementingQUseStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

    }

    public static class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
    }

    public void push(int x) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack2.push(x);
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }




}
