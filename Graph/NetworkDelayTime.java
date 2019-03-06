package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<List<int[]>> graph = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time: times){
            graph.get(time[0]).add(new int[]{time[1],time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[1]-b[1]));

        pq.offer(new int[]{K,0});

        Set<Integer> visited = new HashSet<>();
        int dist = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(!visited.add(curr[0])){
                continue;
            }
            dist = curr[1];
            for(int[] neighbor: graph.get(curr[0])){
                if(!visited.contains(neighbor[0])){
                    pq.offer(new int[]{neighbor[0], neighbor[1] + curr[1]});
                }
            }
        }

        if(visited.size() == N){
            return dist;
        } else {
            return -1;
        }
    }
}
