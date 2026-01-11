class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if(x < 0){
            flag = true;
            x = -1 * x;
        }
        // if(x == Integer.MAX_VALUE) return 0;
        long rev = 0;
        long temp = x;
        while(temp > 0){
            long rem = temp % 10;
            rev = (rev * 10) + rem;
            temp = temp / 10;
        }
        if(flag){
            rev = -1 * rev;
        }
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;
        return (int)rev;
    }
}