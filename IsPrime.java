public class IsPrime {
    public static void main(String[] args) {
        int n = 499979;
        System.out.println(countPrimes(n));


    }

    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        boolean[] check = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!check[i]) {
                count++;
                for (int j = i; j < n; j+= i) {
                    check[j] = true;
                }
            }
        }
        return count;
    }
}
