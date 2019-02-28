package DP;

import java.util.ArrayList;

public class UglyNumberTwo {
    public static int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        int i = 0;
        int j = 0;
        int k = 0;

        while(list.size() < n){
            int m2 = list.get(i) * 2;
            int m3 = list.get(j) * 3;
            int m5 = list.get(k) * 5;

            int min = Math.min(m2, Math.min(m3,m5));
            list.add(min);

            if(min == m2){
                i++;
            } else if(min == m3){
                j++;
            } else if(min == m5){
                k++;
            }
        }
        return list.get(n-1);
    }
}
