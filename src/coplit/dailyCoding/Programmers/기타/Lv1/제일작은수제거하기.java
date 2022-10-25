package coplit.dailyCoding.Programmers.기타.Lv1;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }

        int[] answer = new int[arr.length-1];

        for (int i=0; i<minIdx; i++) {
            answer[i] = arr[i];
        }

        for (int i = minIdx + 1; i < arr.length; i++) {
            answer[i-1] = arr[i];
        }

        return answer;

    }
}
