import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int zeroCnt = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {zeroCnt++; continue;}
            map.put(lotto, true);
        }
        
        int rightCnt = 0;
        for (int num : win_nums) {
            if (map.containsKey(num)) rightCnt++;
        }

        int maxRank = 7 - rightCnt - zeroCnt;
        int minRank = 7 - rightCnt;
        if (maxRank == 7) maxRank = 6;
        if (minRank == 7) minRank = 6;

        return new int[]{maxRank, minRank};
    }
}