package coplit.dailyCoding.Programmers.기타.Lv1;


import java.util.Arrays;
import java.util.Comparator;

public class 자연수뒤집어배열로만들기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(35366)));
    }

    public static int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();

        // 이게 훨씬 빠름
        /**
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            answer[i] = Character.getNumericValue(s.charAt(s.length() - 1 - i));
        }

        return answer;
         **/
    }
}
