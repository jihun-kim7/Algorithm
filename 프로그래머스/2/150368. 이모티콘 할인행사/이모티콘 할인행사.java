import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    // 각 이모티콘 할인률 10~40% 의 중복순열을 구해서 답을 계산한다.
    int[] discounts = {10, 20, 30, 40};
    int emoticonsLen = 0;

    public int[] solution(int[][] users, int[] emoticons) {

        emoticonsLen = emoticons.length;

        List<int[]> cp = new ArrayList<>();
        findCartesianProduct(cp, new int[emoticonsLen], 0);

        List<int[]> amounts = new ArrayList<>();

        for (int[] discountRates : cp) {
            int[] amount = new int[users.length];
            int subscriber = 0;
            int sum = 0;
            for (int i = 0; i < discountRates.length; i++) {
                for (int j = 0; j < amount.length; j++) {
                    int userRate = users[j][0];
                    int discountRate = discountRates[i];
                    if (discountRate >= userRate) {
                        int sales = emoticons[i] * (100 - discountRate) / 100;
                        amount[j] += sales;
                        sum += sales;
                    }
                }
            }

            for (int i = 0; i < amount.length; i++) {
                if (amount[i] >= users[i][1]) {
                    subscriber++;
                    sum -= amount[i];
                }
            }

            amounts.add(new int[]{subscriber, sum});
        }

        int subscriber = 0;
        int sum = 0;

        for (int[] amount : amounts) {
            if (amount[0] > subscriber) {
                subscriber = amount[0];
                sum = amount[1];
            } else if (amount[0] == subscriber) {
                if (amount[1] > sum) {
                    sum = amount[1];
                }
            }
        }

        return new int[]{subscriber, sum};
    }

    public void findCartesianProduct(List<int[]> cp, int[] discountList, int depth) {
        if (depth == emoticonsLen) {
            cp.add(Arrays.copyOf(discountList, discountList.length));
            return;
        }

        for (int discount : discounts) {
            discountList[depth] = discount;
            findCartesianProduct(cp, discountList, depth + 1);
        }
    }
}