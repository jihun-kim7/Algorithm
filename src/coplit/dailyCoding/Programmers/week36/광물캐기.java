package coplit.dailyCoding.Programmers.week36;

import java.util.Arrays;

public class 광물캐기 {


    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        int totalPicks = dia + iron + stone;

        int[][] picksFatigue = new int[totalPicks][6];

        for (int i = 0; i < Math.min(totalPicks * 5, minerals.length); i += 5) {
            int sum = 0;
            int fatigue = 0;

            for (int j = i; j < Math.min(i + 5, minerals.length); j++) {

                if (minerals[j].equals("diamond")) {
                    fatigue = 25;
                } else if (minerals[j].equals("iron")) {
                    fatigue = 5;
                } else {
                    fatigue = 1;
                }

                sum += fatigue;
                picksFatigue[i / 5][j % 5 + 1] = fatigue;
            }

            picksFatigue[i / 5][0] = sum;
        }

        Arrays.sort(picksFatigue, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < picksFatigue.length; i++) {
            String pick = "";

            if (dia > 0) {
                dia -= 1;
                pick = "diamond";
            } else if (iron > 0) {
                iron -= 1;
                pick = "iron";
            } else if (stone > 0) {
                stone -= 1;
                pick = "stone";
            }

            for (int j = 1; j < 6; j++) {
                switch (pick) {
                    case "diamond":
                        answer += (int) Math.ceil(picksFatigue[i][j] / 25.0);
                        break;
                    case "iron":
                        answer += (int) Math.ceil(picksFatigue[i][j] / 5.0);
                        break;
                    case "stone":
                        answer += picksFatigue[i][j];
                        break;
                }
            }
        }


        return answer;
    }


    // 백트래킹
    // 곡괭이 순서: 다이아몬드 -> 철 -> 돌 순서로 실행한다. 좋은거 못쓰면 손해이므로 좋은것부터 소모한다.

//    int answer;
//    List<Integer> answerList = new ArrayList<>();
//
//    public int solution(int[] picks, StringTest[] minerals) {
//        answer = 0;
//        backTracking(picks, minerals, 0);
//        answer = answerList.stream().min(Integer::compareTo).orElse(0);
//
//        return answer;
//    }
//
//    public void backTracking(int[] picks, StringTest[] minerals, int depth) {
//        if (depth == minerals.length || Arrays.stream(picks).allMatch(i -> i == 0)) {
//            answerList.add(answer);
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            int pick = picks[i];
//            if (pick == 0) continue;
//            int sum = 0;
//            int min = Math.min(5, minerals.length - depth);
//            for (int j = 0; j < min; j++) {
//                if (minerals[depth+j].equals("diamond")) {
//                    sum += (i == 0 ? 1 : (i == 1 ? 5 : 25));
//                } else if (minerals[depth+j].equals("iron")) {
//                    sum += (i == 0 || i == 1 ? 1 : 5);
//                } else {
//                    sum += 1;
//                }
//            }
//            picks[i] -= 1;
//            answer += sum;
//            backTracking(picks, minerals, depth + min);
//            picks[i] += 1;
//            answer -= sum;
//        }
//    }

}
