import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int preNum = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : arr) {
            if (x == preNum) continue;
            list.add(x);
            preNum = x;
        }

        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}