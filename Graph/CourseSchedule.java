package Graph;

import java.util.LinkedList;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null) {
            return false;
        }

        int len = prerequisites.length;

        if (numCourses == 0 || len == 0) {
            return true;
        }

        //pCounter: index: prerequisite course number, value: each prerequisite serve as how many courses' prerequisite
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();

        //queue's first elements: courses who do not serve as prerequisite
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }

        //how many courses do not serve as prerequisite
        int numNoPre = queue.size();

        while (!queue.isEmpty()) {
            int top = queue.removeFirst();
            for (int i = 0; i < len; i++) {
                //if the course[i] has [0] as prerequisite for [1],which is current queue polled out element
                if (prerequisites[i][1] == top) {
                    //course[i] 's serving as prerequisite number deduct from 1
                    pCounter[prerequisites[i][0]]--;
                    //if course[i] does not serve as any other courses' prerequisite course
                    if (pCounter[prerequisites[i][0]] == 0) {
                        //numNoPre plus one
                        numNoPre++;
                        //queue added course[i]
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numCourses == numNoPre;

    }
}
