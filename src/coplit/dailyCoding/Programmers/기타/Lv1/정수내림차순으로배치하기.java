package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 정수내림차순으로배치하기 {

    //StringBuilder도 reverse 메소드가 있음
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Comparator.reverseOrder());
        return Long.parseLong(String.join("",arr));
    }
}
