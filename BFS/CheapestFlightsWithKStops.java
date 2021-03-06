package BFS;

import java.util.*;

public class CheapestFlightsWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            int srcCity = flight[0];
            if (map.containsKey(srcCity)) {
                List<int[]> array = map.get(srcCity);
                array.add(flight);
            } else {
                List<int[]> array = new ArrayList<>();
                array.add(flight);
                map.put(srcCity, array);
            }
        }
        if (!map.containsKey(src)) {
            return -1;
        }
        LinkedList<int[]> q = new LinkedList<>();
        int[] a3 = new int[3];
        a3[0] = src;
        a3[1] = K;
        a3[2] = 0;
        q.offer(a3);
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0 && !q.isEmpty()) {
                int[] a = q.poll();
                int srcCity = a[0];
                int stops = a[1];
                int price = a[2];
                stops--;
                if (stops < -1) {
                    continue;
                }
                if (!map.containsKey(srcCity)) {
                    continue;
                }
                List<int[]> array = map.get(srcCity);
                for (int[] a2 : array) {
                    int dstCity = a2[1];
                    if (dstCity == dst) {
                        if (a2[2] + price < min) {
                            min = a2[2] + price;
                        }
                    } else {
                        int[] a5 = new int[3];
                        a5[0] = a2[1];
                        a5[1] = stops;
                        a5[2] = a2[2] + price;
                        q.offer(a5);
                    }
                }
                size--;
            }


        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
