package G;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) {
            return digits;
        }
        int n = digits.length;
        if(digits[n-1] != 9){
            digits[n-1]++;
            return digits;
        }

        int i = n - 1;
        while(i >= 0){
            if(digits[i] == 9){
                digits[i] = 0;
                i--;
            } else {
                digits[i]++;
                break;
            }
        }

        if(i == -1 && digits[0] == 0){
            int[] result = new int[n + 1];
            result[0] = 1;
            for(int j = 1; j < n + 1; j++){
                result[j] = digits[j - 1];
            }
            return result;
        }

        return digits;

    }
}