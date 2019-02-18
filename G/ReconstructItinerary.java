package G;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    static HashMap<String, PriorityQueue<String>> map;
    static LinkedList<String> result;

    public static List<String> findItinerary(String[][] tickets) {
        map = new HashMap<String, PriorityQueue<String>>();
        result = new LinkedList<String>();

        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<String>();
                map.put(ticket[0], q);
            }
            map.get(ticket[0]).offer(ticket[1]);
        }

        dfs("JFK");
        return result;
    }

    public static void dfs(String s) {
        PriorityQueue<String> q = map.get(s);

        while (q != null && !q.isEmpty()) {
            dfs(q.poll());
        }

        result.addFirst(s);
    }
}