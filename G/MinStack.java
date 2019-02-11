package G;

public class MinStack {
        int size = 20;
        int[] intArray;
        int min;
        int top = -1;

        /** initialize your data structure here. */
        public MinStack() {
            intArray = new int[size];
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(top == size - 1){
                size *= 2;
                int[] newArray = new int[size];
                for(int i = 0; i < intArray.length; i++){
                    newArray[i] = intArray[i];
                }
                intArray = newArray;
            }
            top++;
            intArray[top] = x;
            if(x < min){
                min = x;
            }
        }

        public void pop() {
            if(top >= 0){
                top--;
            }
            int currentMin = Integer.MAX_VALUE;
            for(int i = 0; i <= top; i++){
                if(currentMin > intArray[i]){
                    currentMin = intArray[i];
                }
            }
            min = currentMin;
        }

        public int top() {
            if(top >= 0){
                return intArray[top];
            } else {
                return -2;
            }
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */