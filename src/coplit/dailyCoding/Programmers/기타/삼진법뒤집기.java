package coplit.dailyCoding.Programmers.기타.Lv1;

public class 삼진법뒤집기 {
    public int solution(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.append(n % 3);
            n/=3;
        }

        return Integer.parseInt(s.toString(),3);
    }

}
