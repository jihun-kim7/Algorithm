package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n + 2];

        for (int l : lost) {
            people[l]--;
        }

        for (int r : reserve) {
            people[r]++;
        }

        Arrays.sort(lost);
        int answer = n;
        for (int l : lost) {
            if (people[l] != -1) {
                continue;
            }
            if (people[l - 1] == 1) {
                people[l - 1]--;
            } else if (people[l + 1] == 1) {
                people[l + 1]++;
            } else answer--;
        }

        return answer;
    }
}
