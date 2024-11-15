import java.util.*;

class Solution {
    // 백트래킹
    // 곡괭이 순서: 다이아몬드 -> 철 -> 돌 순서로 실행한다. 좋은거 못쓰면 손해이므로 좋은것부터 소모한다.

    int answer;
    List<Integer> answerList = new ArrayList<>();

    public int solution(int[] picks, String[] minerals) {
        answer = 0;
        backTracking(picks, minerals, 0);
        answer = answerList.stream().min(Integer::compareTo).orElse(0);

        return answer;
    }

    public void backTracking(int[] picks, String[] minerals, int depth) {
        if (depth == minerals.length || Arrays.stream(picks).allMatch(i -> i == 0)) {
            answerList.add(answer);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int pick = picks[i];
            if (pick == 0) continue;
            int sum = 0;
            int min = Math.min(5, minerals.length - depth);
            for (int j = 0; j < min; j++) {
                if (minerals[depth+j].equals("diamond")) {
                    sum += (i == 0 ? 1 : (i == 1 ? 5 : 25));
                } else if (minerals[depth+j].equals("iron")) {
                    sum += (i == 0 || i == 1 ? 1 : 5);
                } else {
                    sum += 1;
                }
            }
            picks[i] -= 1;
            answer += sum;
            backTracking(picks, minerals, depth + min);
            picks[i] += 1;
            answer -= sum;
        }
    }
}