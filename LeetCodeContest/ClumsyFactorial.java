package LeetCodeContest;

public class ClumsyFactorial {
    public int clumsy(int N) {
        int result = 0;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        if (N == 3) {
            return 6;
        }


        if (N >= 4) {
            result = N * (N - 1) / (N - 2) + (N - 3);

            N -= 4;
        }

        while (N >= 4) {
            result = result - N * (N - 1) / (N - 2) + (N - 3);

            N -= 4;
        }

        if (N == 0) {
            return result;
        } else if (N == 1) {
            return result - 1;
        } else if (N == 2) {
            return result - 2 * 1;
        } else {
            return result - 3 * 2 / 1;
        }

    }
}
