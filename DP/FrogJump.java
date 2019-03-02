package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        int n = stones.length;

        if (n == 1) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }

        Integer[] array1 = new Integer[n];
        for(int i = 0; i < n; i++){
            array1[i] = stones[i];
        }

        if(n == 2 && stones[1] >= 2){
            return false;
        }

        HashSet<Integer> set0 = map.get(0);
        set0.add(0);

        HashSet<Integer> set1 = map.get(1);
        set1.add(1);
        set1.add(2);

        for (int i = 1; i < n; i++) {
            HashSet<Integer> set = map.get(i);
            for (int j : set) {
                int index = Arrays.asList(array1).indexOf(stones[i]+j);
                if (index > 0) {
                    if (j - 1 > 0 && j - 1 < n) {
                        map.get(index).add(j - 1);
                    }
                    if (j < n) {
                        map.get(index).add(j);
                    }
                    if (j + 1 < n) {
                        map.get(index).add(j + 1);
                    }
                }
            }
        }

        return map.get(n-1).size() != 0;
    }
}
