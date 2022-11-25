package coplit.dailyCoding.k;

import java.util.Arrays;

public class third {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{100, 101, 102, 103, 104}, new int[]{1, 2}, new int[]{2, 4})));
    }

    public static int[] solution(int[] numbers, int[] start, int[] finish) {
        int[] dp = new int[numbers.length];

        dp[0] = numbers[0];

        for (int i=1; i<dp.length; i++) {
            dp[i] = dp[i-1] + numbers[i];
        }

        int[] answer = new int[start.length];

        for (int i=0; i<answer.length; i++) {
            answer[i] = dp[finish[i]] - dp[start[i]] + numbers[start[i]];
        }

        return answer;
    }
}
