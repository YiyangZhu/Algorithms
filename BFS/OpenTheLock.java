package BFS;

import java.util.HashSet;
import java.util.LinkedList;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        int t = Integer.valueOf(target);
        HashSet<Integer> set = new HashSet<>();
        for (String s : deadends) {
            set.add(Integer.valueOf(s));
        }
        if (set.contains(0)) {
            return -1;
        }
        LinkedList<String[]> q = new LinkedList<>();
        boolean[] checked = new boolean[10000];
        checked[0] = true;
        boolean[] visited = new boolean[10000];
        String[] ori = new String[2];
        ori[0] = "0000";
        ori[1] = "0";
        q.add(ori);
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            String[] current = q.poll();
            String numS = current[0];
            int num = Integer.valueOf(numS);
            int count = Integer.valueOf(current[1]);
            count++;

            for (int i = 0; i < 4; i++) {
                int tmp = 1;
                if (i == 0) {
                    tmp = 1000;
                } else if (i == 1) {
                    tmp = 100;
                } else if (i == 2) {
                    tmp = 10;
                }

                int result1;
                if (numS.charAt(i) == '9') {
                    result1 = enqueue(num - 9 * tmp, t, count, min, checked, q, visited, set);

                } else {
                    result1 = enqueue(num + tmp, t, count, min, checked, q, visited, set);

                }
                min = result1 >= 0 ? result1 : min;

                if (numS.charAt(i) == '0') {
                    result1 = enqueue(num + 9 * tmp, t, count, min, checked, q, visited, set);
                } else {
                    result1 = enqueue(num - tmp, t, count, min, checked, q, visited, set);
                }
                min = result1 >= 0 ? result1 : min;
            }
            visited[num] = true;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int enqueue(int num2, int t, int count, int min, boolean[] checked, LinkedList<String[]> q, boolean[] visited, HashSet<Integer> set) {
        if (visited[num2] || set.contains(num2)) {
            return -1;
        }
        if (num2 == t) {
            if (count < min) {
                return count;
            }
        } else {
            if (!checked[num2]) {
                checked[num2] = true;
                String[] tmp = new String[2];
                String numS = Integer.toString(num2);
                while (numS.length() < 4) {
                    numS = "0" + numS;
                }
                tmp[0] = numS;
                tmp[1] = Integer.toString(count);
                q.add(tmp);
            }
        }
        return -1;
    }
}