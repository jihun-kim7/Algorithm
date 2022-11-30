import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int answer = 0;
        
        for (int i=n-1; i>=0; i--) {
            if (citations[i] <= n-i) {
                answer = Math.max(citations[i],answer);
                break;
            } else {
                answer = n-i;
            }
        }

        return answer;
    }
}