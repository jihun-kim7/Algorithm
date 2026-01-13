package coplit.dailyCoding.solo;

import java.util.Arrays;


// 부등호에 맞는 최대값, 최소값의 차이 구하기

public class InequalityNumber {

    public static void main(String[] args) {
        long output = inequalityNumber("<,>,<");
        System.out.println(output); // --> 8,754 (9,786 - 1,032)
    }

    public static long inequalityNumber(String signs) {
        String[] arr = signs.split(",");
        System.out.println(Arrays.toString(arr));
        int[] digits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reverseDigits = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        long min = aux(-1, arr, new String[]{}, digits, new boolean[10]);
        long max = aux(-1, arr,  new String[]{}, reverseDigits, new boolean[10]);
        return max - min;
    }
    public static long aux(int idx, String[] signs, String[] nums, int[] digits, boolean[] isVisited) {
        if(idx == signs.length) {
            // 부등호 수를 만든 경우
            System.out.println(Arrays.toString(nums));
            String result = String.join("", nums);
            System.out.println(result);
            return Long.parseLong(result);
        }

        String sign;

        if(idx != -1) {
            sign = signs[idx];
        } else {
            sign = "NULL";
        }
        for(int i = 0; i < digits.length; i++) {
            // 숫자를 차례대로 검토한다.
            // max를 구할 때는 9부터, min을 구할 때는 0부터
            int right = digits[i];
            // 이전 단계에서 사용한 숫자인 경우 스킵
            if (isVisited[right]) continue;

            // 첫번째 숫자가 아닌 경우에는 조건이 중요하다.
            if (idx >= 0) {
                // 항상 바로 직전의 숫자와 비교하면 된다.
                int left = Integer.parseInt(nums[nums.length - 1]);
                if(sign.equals("<") && left >= right) break;
                if(sign.equals(">") && left <= right) break;
            }

            // 조건을 만족하거나 첫번째 숫자인 경우
            isVisited[right] = true;
            String[] stringArr = Arrays.copyOf(nums, nums.length + 1);
            stringArr[stringArr.length - 1] = String.valueOf(right);
            long target = aux(idx + 1, signs, stringArr, digits, isVisited);

            if (target != -1) {
                // 부등호 수를 이미 찾은 경우 탐색을 더 할 필요가 없다.
                return target;
            }
            // 탐색에 실패한 경우, 시도한 숫자의 상태(사용중)를 원래대로(사용안함) 바꿔놔야 한다.
            isVisited[right] = false;
        }
        return -1;
    }

}
