package G;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() < 1) {
            return list;
        }

        Comparator<Interval> comp = Comparator.comparing(Interval->Interval.start);
        PriorityQueue<Interval> queue = new PriorityQueue<>(comp);

        for(Interval i: intervals){
            queue.offer(i);
        }

        list.add(queue.poll());

        while(!queue.isEmpty()){
            Interval i = queue.poll();
            int size = list.size();
            Interval lastI = list.get(size - 1);
            if (i.start <= lastI.end){
                Interval newI = new Interval(lastI.start,Math.max(i.end,lastI.end));
                list.remove(lastI);
                list.add(newI);
            } else {
                list.add(i);
            }
        }
        return list;

    }
}