package coplit.dailyCoding.solo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 정수를 요소로 갖는 문자열을 입력받아 다음의 조건을 만족하는 LIS*의 길이를 리턴해야 합니다.
 *
 * LIS: 배열의 연속되지 않는 부분 배열 중 모든 요소가 엄격하게 오름차순으로 정렬된 가장 긴 부분 배열(Longest Increasing Subsequence)
 * 배열 [1, 2, 3]의 subseqeunce는 [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3] 입니다.
 * 엄격한 오름차순: 배열이 동일한 값을 가진 요소없이 오름차순으로 정렬되어 있는 경우를 말합니다.
 */


public class LIS {
    public static void main(String[] args) {
        int output = LIS(new int[]{3, 10, 2, 1, 20});
        System.out.println(output); // --> 3 (3, 10, 20)
    }

    public static int LIS(int[] arr) {
        // TODO:
        // dp 구해서 i번째부터 idx -1씩해서 비교. 만약 i번째가 더 큰값이면 dp[i] = dp[idx] + 1로 변경
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);

        for (int i=0; i<arr.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) dp[i] = dp[j]+1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
