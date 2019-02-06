package G;

public class PowXN {
    public static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        } else if(n < 0){
            x = 1 / x;
            n = -n;
        }
        return myPowHelper(x, n);
    }

    public static double myPowHelper(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n % 2 == 0){
            return myPowHelper(x * x, n / 2);
        } else {
            return x * myPowHelper(x*x, n / 2);
        }
    }

}