class Solution {
    public static void fillPrimesUpToMillion(HashSet<Integer> primes) {
        int limit = 1000000;
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    public int countPrimeSetBits(int left, int right) {
        HashSet<Integer> hss = new HashSet<>();
        fillPrimesUpToMillion(hss);
        int res = 0;
        for (int i = left; i <= right; i++) {
            int n = i;
            int count = 0;
            while (n != 0) {
                n = n & (n - 1); // removes lowest set bit
                count++;
            }
            if(hss.contains(count)){
                res++;
            }
        }
        return res;
    }
}