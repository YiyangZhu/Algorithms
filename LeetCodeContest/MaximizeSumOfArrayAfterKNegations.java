package LeetCodeContest;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (K == 0) {
            int result = 0;
            for (int i : A) {
                result += i;
            }
            return result;
        }

        Arrays.sort(A);
        if (A[0] >= 0) {
            if (K % 2 == 0) {
                int result = 0;
                for (int i : A) {
                    result += i;
                }
                return result;
            } else {
                A[0] = -A[0];
                int result = 0;
                for (int i : A) {
                    result += i;
                }
                return result;
            }
        }

        int i = 0;
        while (A[i] < 0 && K > 0) {
            A[i] = -A[i];
            i++;
            K--;
        }
        Arrays.sort(A);
        if (K % 2 == 0) {
            int result = 0;
            for (int j : A) {
                result += j;
            }
            return result;
        } else {
            A[0] = -A[0];
            int result = 0;
            for (int j : A) {
                result += j;
            }
            return result;
        }
    }
}
