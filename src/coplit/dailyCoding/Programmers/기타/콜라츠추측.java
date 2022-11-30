package coplit.dailyCoding.Programmers.기타.Lv1;

public class 콜라츠추측 {
    public static void main(String[] args) {
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        long l = num;
        int cnt = 0;
        for (int i = 0; i < 500; i++) {
            if (l == 1) return i;
            l = l%2 == 0 ? l/2 : 3*l + 1;
        }
        return -1;
    }
}
