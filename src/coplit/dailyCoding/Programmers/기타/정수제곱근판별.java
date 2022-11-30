package coplit.dailyCoding.Programmers.기타.Lv1;

public class 정수제곱근판별 {

    public static void main(String[] args) {
        long solution = solution(121);
        System.out.println("solution = " + solution);
    }

    public static long solution(long n) {
        double sqrt = Math.sqrt(n);
        return (int)sqrt == sqrt ? (long) Math.pow(sqrt+1,2) : -1;
    }
}
