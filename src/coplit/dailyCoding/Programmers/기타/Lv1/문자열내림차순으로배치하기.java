package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내림차순으로배치하기 {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
//        String[] arr = s.split("");
//        Arrays.sort(arr, Comparator.reverseOrder());
//        return String.join("",arr);

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        return sb.reverse().toString();
    }
}
