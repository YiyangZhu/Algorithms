package MS;

public class FiboDP {
    public static void main(String[] args){
        int index = 6;
        System.out.println(fib(index));
    }

    public static int fib(int n){
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;

        if(n == 0){
            return f0;
        }
        if(n == 1){
            return f1;
        }
        if (n == 2){
            return f2;
        }
        for(int i = 3; i <= n;i++){
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;
    }
}
