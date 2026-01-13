package coplit.dailyCoding.Programmers.기타.Lv1;


public class 하샤드수 {
    public boolean solution(int x) {
        // 첫 풀이
//        StringTest[] arr = StringTest.valueOf(x).split("");
//        int sum = 0;
//        for (StringTest s : arr) {
//            sum += Integer.parseInt(s);
//        }
//
//        return x % sum == 0;

        int sum = 0;
        int origin = x;
        while (x > 0) {
            sum += x%10;
            x /= 10;
        }

        return origin % sum == 0;
    }
}
