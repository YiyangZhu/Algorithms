package BS;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num <= 0){
            return false;
        }
        if(num == 1){
            return true;
        }

        int j = num / 2;
        while( j * j < 0 || j * j > num){
            j /= 2;
        }


        for(int k = j; k <= 2 * j; k++){
            if(k * k == num){
                return true;
            }
        }

        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if(num <= 0){
            return false;
        }
        if(num == 1){
            return true;
        }

        for(int i = 1; i <= num / i; i++){
            if(i * i == num){
                return true;
            }
        }

        return false;
    }

    public boolean isPerfectSquareBS(int num) {
        if(num <= 0){
            return false;
        }

        if(num == 1){
            return true;
        }

        int left = 1;
        int right = num;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int t = mid * mid;
            if(t == num){
                return true;
            } else {
                if(left == right){
                    return false;
                }
            }
            if(t < 0 || t > num){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}