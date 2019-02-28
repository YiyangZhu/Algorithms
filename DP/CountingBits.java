package DP;

public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for(int i = 0; i <= num; i++){
            result[i] = count(i);
        }

        return result;
    }

    public int count(int i){
        int res = 0;
        while (i != 0){
            if(i % 2 == 1){
                res++;
            }
            i /= 2;
        }
        return res;
    }
}
