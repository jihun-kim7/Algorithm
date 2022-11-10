package coplit.dailyCoding.Programmers.기타.Lv1;

public class 타겟넘버 {
    public static void main(String[] args) {
        타겟넘버 tn = new 타겟넘버();
        System.out.println(tn.solution(new int[]{1,1,1,1,1}, 5));
    }

    int answer = 0;
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }

    public void dfs(int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target)
                ++answer;
            return;
        }
        dfs(idx + 1, sum + numbers[idx]);
        dfs(idx + 1, sum - numbers[idx]);
    }
}
