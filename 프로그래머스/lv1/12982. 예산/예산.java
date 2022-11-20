import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int now = 0;
        int answer = 0;
        for (int x : d) {
            if (now + x <= budget) {
                now += x;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}