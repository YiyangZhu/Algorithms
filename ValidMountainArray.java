import java.util.Arrays;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length <= 2) {
            return false;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B);
        int max = B[B.length - 1];
        int maxIndex = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == max) {
                maxIndex = i;
                break;
            }
        }
        if (maxIndex > 0 && maxIndex < A.length-1) {

        } else {
            return false;
        }
        for (int i = 0; i < maxIndex; i++) {

            if (A[i] >= A[i + 1]) {
                return false;
            }
        }
        for (int i = maxIndex; i < A.length - 1; i++) {

            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
