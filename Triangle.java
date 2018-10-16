import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> line1 = new ArrayList<>();
        line1.add(2);
        triangle.add(line1);
        List<Integer> line2 = new ArrayList<>();
        line2.add(3);
        line2.add(4);
        triangle.add(line2);
        List<Integer> line3 = new ArrayList<>();
        line3.add(6);
        line3.add(5);
        line3.add(7);
        triangle.add(line3);
        List<Integer> line4 = new ArrayList<>();
        line4.add(4);
        line4.add(1);
        line4.add(8);
        line4.add(3);
        triangle.add(line4);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        int[] result = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            result[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j + 1]);
            }
        }
        return result[0];

    }
}
