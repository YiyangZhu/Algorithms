import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static class Interval {
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

    public static void main(String[] args) {
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(8,10);
        Interval i3 = new Interval(15,18);
        Interval i4 = new Interval(2,6);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        merge(intervals);

    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        Interval pre = intervals.get(0);
        for(int i = 0; i < intervals.size();i++){
            Interval current = intervals.get(i);
            if(current.start > pre.end){
                result.add(pre);
                pre = current;
            } else {
                Interval merged = new Interval(pre.start,Math.max(pre.end,current.end));
                pre = merged;
            }
        }
        result.add(pre);
        displayIntervals(result);
        return result;

    }

    public static void displayIntervals(List<Interval> intervals){
        for(Interval interval:intervals){
            System.out.print("["+interval.start+","+interval.end+"]\t");
        }
        System.out.println();
    }

}
