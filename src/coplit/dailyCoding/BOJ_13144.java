package coplit.dailyCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_13144 {

    static int N;
    static int[] arr;
    static int[] dp;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);
        int end = 0;

        for (int i = 1; i < N; i++) {

            if (set.contains(arr[i])) {
                for (int j = i - 1; j >= end; j--) {
                    if (arr[j] == arr[i]) {
                        end = j + 1;
                        dp[i] = i-j;
                        break;
                    }

                    if (j == end) {
                        dp[i] = i-j+1;
                        break;
                    }
                }
            } else {
                set.add(arr[i]);
                dp[i] = dp[i-1] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            answer += dp[i];
        }

        System.out.println(answer);
    }
}