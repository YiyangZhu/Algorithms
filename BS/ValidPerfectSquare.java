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
}