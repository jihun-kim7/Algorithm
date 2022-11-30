package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
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
