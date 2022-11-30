package coplit.dailyCoding.Programmers.기타.Lv1;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int sum = 0;

        for (int x : numbers) {
            sum += x;
        }

        return 45-sum;
    }
}
