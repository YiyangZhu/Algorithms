package BS;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FindRightInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }

        //key: interval.start, value: index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }

        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (Interval i : intervals) {
            queue.offer(i);
        }

        Interval[] sortedArray = new Interval[intervals.length];

        int i = 0;
        while (!queue.isEmpty()) {
            sortedArray[i] = queue.poll();
            i++;
        }

        int[] result = new int[sortedArray.length];

        for (int j = 0; j < result.length; j++) {
            result[j] = -1;
            for (int k = 0; k < sortedArray.length; k++) {
                if (sortedArray[k].start >= intervals[j].end) {
                    result[j] = map.get(sortedArray[k].start);
                    break;
                }
            }
        }

        return result;
    }
}
