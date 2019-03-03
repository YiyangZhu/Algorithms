package BS;

public class Sqrt_x {
    public int mySqrt(int x) {
        if(x <= 0){
            return 0;
        }
        int i = 1;
        while(i * i <= x  && i * i > 0){
            i++;
        }
        return i-1;

    }
}
