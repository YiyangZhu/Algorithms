package BS;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }

        if(dividend == 0){
            return 0;
        }

        if(divisor == -1 && dividend == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }

        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int result = 0;
        while(pDividend >= pDivisor){
            result++;
            pDividend -= pDivisor;
        }

        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0){
            return result;
        } else {
            return -result;
        }
    }
}
