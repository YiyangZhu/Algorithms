package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(id);
        int result = 0;
        while (!q.isEmpty()) {
            Employee e = map.get(q.poll());
            result += e.importance;
            for (int sub : e.subordinates) {
                q.add(sub);
            }
        }
        return result;
    }
}
