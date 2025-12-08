class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] arr = new boolean[n];
       
        for(int i = 2; i < n; i++){
            arr[i] = true;
        }
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (arr[i]) {
                for (int j = i * i; j < n; j += i) {
                    if (arr[j]) {
                        arr[j] = false;
                    }
                }
            }
        }
        int count = 0;
        for(boolean b: arr){
            if(b){
                count++;
            }
        }
        return count;
    }
}