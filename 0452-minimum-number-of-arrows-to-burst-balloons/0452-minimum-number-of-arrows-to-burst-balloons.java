class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int curr = 0;
        for(int i = 0; i < points.length; i++){
            if(res == 0 || points[i][0] > curr){
                res++;
                curr = points[i][1];
            }
        }
        return res;
    }
}