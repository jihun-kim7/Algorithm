package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.*;

public class 문자열내마음대로정렬하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }
                return s1.charAt(n) - s2.charAt(n);
            }
        });

        return strings;

        // 람다식으로 짧게 가능하다 .
//        Arrays.sort(strings, (s1,s2) -> {
//                    if (s1.charAt(n) == s2.charAt(n)) {
//                        return s1.compareTo(s2);
//                    }
//                    return s1.charAt(n) - s2.charAt(n);
//                }
//        );
//
//        return strings;

    }
}
