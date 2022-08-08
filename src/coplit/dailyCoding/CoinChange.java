package coplit.dailyCoding;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int total = 4;
        int[] coins = new int[]{1, 2, 3};
        int output = coinChange(total, coins);
        System.out.println(output); // --> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])
    }

    public static int coinChange(int total, int[] coins) {
        // TODO :
        Arrays.sort(coins);
        return dfs(0,coins,0,total,0);
    }

    public static int dfs(int count, int[] coins, int start, int total,int now) {
        if (now == total) {
            return ++count;
        }

        for (int i=start; i<coins.length; i++) {
            if (now+coins[i] > total) break;
            count = dfs(count, coins, i, total, now+coins[i]);
        }

        return count;
    }
}
