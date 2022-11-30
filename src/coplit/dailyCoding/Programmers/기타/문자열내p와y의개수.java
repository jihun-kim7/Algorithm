package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.Arrays;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {
        solution("Pyy");
    }

    static boolean solution(String s) {
        String lowerCase = s.toLowerCase();
        String[] arr = lowerCase.split("");
        int p = 0;
        int y = 0;

        for (String str : arr) {
            if (str.equals("p")) {
                p++;
            } else if (str.equals("y")) {
                y++;
            }
        }

        return p==y;
    }
}
