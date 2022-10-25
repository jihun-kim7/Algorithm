package coplit.dailyCoding.Programmers.기타.Lv1;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long need = 0;

        for (int i = 1; i <= count; i++) {
            need += price*i;
        }

        return Math.max(need - money, 0);
    }
}
