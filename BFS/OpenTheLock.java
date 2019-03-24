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
            if (numS.charAt(0) == '9') {
                int result7 = enqueue(num - 9000, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 1000, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else if (numS.charAt(0) == '0') {
                int result7 = enqueue(num + 1000, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num + 9000, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else {
                int result7 = enqueue(num + 1000, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 1000, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            }

            if (numS.charAt(1) == '9') {
                int result7 = enqueue(num - 900, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 100, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else if (numS.charAt(1) == '0') {
                int result7 = enqueue(num + 100, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num + 900, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else {
                int result7 = enqueue(num + 100, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 100, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            }

            if (numS.charAt(2) == '9') {
                int result7 = enqueue(num - 90, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 10, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else if (numS.charAt(2) == '0') {
                int result7 = enqueue(num + 10, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num + 90, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else {
                int result7 = enqueue(num + 10, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 10, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            }

            if (numS.charAt(3) == '9') {
                int result7 = enqueue(num - 9, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 1, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else if (numS.charAt(3) == '0') {
                int result7 = enqueue(num + 1, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num + 9, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            } else {
                int result7 = enqueue(num + 1, t, count, min, checked, q, visited, set);
                if (result7 >= 0) {
                    min = result7;
                }
                int result8 = enqueue(num - 1, t, count, min, checked, q, visited, set);
                if (result8 >= 0) {
                    min = result8;
                }
            }
            visited[num] = true;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int enqueue(int num2, int t, int count, int min, boolean[] checked, LinkedList<String[]> q, boolean[] visited, HashSet<Integer> set) {
        if (num2 > 9999 || num2 < 0 || visited[num2] || set.contains(num2)) {
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