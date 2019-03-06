package Graph;

import java.util.LinkedList;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] p) {
        if(p == null || p.length == 0 || p[0].length == 0|| numCourses == 0){
            int[] result = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                result[i] = i;
            }
            return result;
        }

        int len = p.length;

        int[] pCounter = new int[numCourses];

        for(int[] i: p){
            pCounter[i[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < len; i++){
            if(pCounter[i] == 0){
                queue.add(i);
            }
        }

        int j = 0;
        int[] result = new int[numCourses];
        int numNoPre = queue.size();

        while(!queue.isEmpty()){
            int currentCourse = queue.removeFirst();
            result[j++] = currentCourse;
            for(int[] i: p){
                if(i[1] == currentCourse){
                    pCounter[i[0]]--;
                    if(pCounter[i[0]] == 0){
                        queue.add(i[0]);
                        numNoPre++;
                    }
                }
            }
        }

        if(numNoPre == numCourses){
            return result;
        } else {
            return new int[0];
        }
    }
}