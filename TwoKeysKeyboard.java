public class TwoKeysKeyboard {
    public static void main(String[] args){
        int i1 = 1;
        int i2 = 2;
        int i3 = 3;
        int i4 = 4;
        int i5 = 5;
        int i6 = 6;
        int i10 = 10;
        System.out.println(minSteps(7));
        System.out.println(minSteps(i2));
        System.out.println(minSteps(i3));
        System.out.println(minSteps(i4));
        System.out.println(minSteps(i5));
        System.out.println(minSteps(i6));
        System.out.println(minSteps(i10));
        System.out.println(minStepsSaveSpace(i10));

    }

    public static int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 2;
        }
        int result = n;
        for(int i = n - 1; i > 1;i--){
            if(n % i == 0){
                result = Math.min(result,minSteps(n / i) + i);
            }
        }
        return result;
    }

    public static int minStepsSaveSpace(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 2;
        }
        int result = 0;
        for(int i = 2; i <= n; i++){
            while(n % i == 0){
                result += i;
                n /= i;
            }
        }
        return result;
    }
}
