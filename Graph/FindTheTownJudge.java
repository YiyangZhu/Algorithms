package Graph;

import java.util.HashMap;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if(trust == null){
            return -1;
        }

        if(N == 1 && trust.length == 0){
            return 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] a1: trust){
            int personNum = a1[1];
            if(map.containsKey(personNum)){
                int count = map.get(personNum);
                count++;
                map.put(a1[1],count);
            } else {
                map.put(a1[1],1);
            }
        }

        int judge = -1;
        int max = Integer.MIN_VALUE;
        for(int i: map.keySet()){
            if(map.get(i) > max){
                max = map.get(i);
                judge = i;
            }
        }

        for(int[] a1: trust){
            if(a1[0] == judge){
                return -1;
            }
        }
        return judge;
    }
}
