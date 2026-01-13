package coplit.dailyCoding.solo;

/**
 * 문자열을 입력받아 다음의 조건을 만족하는 LPS*를 찾아 그 길이를 리턴해야 합니다.
 * <p>
 * LPS: 주어진 문자열의 가장 긴 접두어이자 접미어(Longest Prefix which is also Suffix)
 * non-overlapping: 접두어와 접미어는 서로 겹치는 부분이 없어야 합니다. 다시 말해, prefix와 suffix는 문자열의 동일한 인덱스에 위치한 문자를 요소로 가지면 안 됩니다.
 */

public class LPS {
    public static void main(String[] args) {
        int output = LPS("aaaaa");
        System.out.println(output); // --> 2
    }

    public static int LPS(String str) {
        // TODO:
        String prefix;
        String suffix;
        int half = str.length() / 2;
        int sufStart = str.length() / 2;
        if (str.length() % 2 == 1) sufStart++;
        for (int i = 0; i < half; i++) {
            prefix = str.substring(0, half--);
            suffix = str.substring(sufStart++);
            if (prefix.equals(suffix)) return prefix.length();
        }
        return 0;
    }
}


//        int leftidx = 0;
//        int rightidx = (int) Math.ceil(str.length() / 2);
//        while (rightidx < str.length()) {
//            if (str.charAt(leftidx) == str.charAt(rightidx)) {
//                leftidx++;
//                rightidx++;
//            }
//
//            else {
//                rightidx = rightidx - leftidx + 1;
//                leftidx = 0;
//            }
//        }
//
//        return leftidx;

