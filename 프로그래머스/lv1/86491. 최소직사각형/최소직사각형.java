class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for(int[] size : sizes) {
            int big;
            int small;
            if (size[0] > size[1]) {
                big = size[0];
                small = size[1];
            } else {
                big = size[1];
                small = size[0];
            }
            if (big > max) max = big;
            if (small > min) min = small;
        }
        
        return max*min;
    }
}