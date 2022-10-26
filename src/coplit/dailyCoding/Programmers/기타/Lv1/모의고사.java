package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) {
                answer[0]++;
            }
            if (answers[i] == person2[i % person2.length]) {
                answer[1]++;
            }
            if (answers[i] == person3[i % person3.length]) {
                answer[2]++;
            }
        }

        int max = Arrays.stream(answer).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (answer[i] == max) {
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(n -> n).toArray();
    }
}
