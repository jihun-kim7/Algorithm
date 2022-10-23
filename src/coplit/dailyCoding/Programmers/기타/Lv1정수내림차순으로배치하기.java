package coplit.dailyCoding.Programmers.기타;

import java.util.Arrays;
import java.util.Comparator;

public class Lv1정수내림차순으로배치하기 {
    
    //StringBuilder도 reverse 메소드가 있음
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Comparator.reverseOrder());
        return Long.parseLong(String.join("",arr));
    }
}
