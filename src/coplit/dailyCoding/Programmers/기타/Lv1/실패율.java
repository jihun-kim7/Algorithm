package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.*;

public class 실패율 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(7, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] cntStages = new int[N+2];

        for (int stage : stages) {
            cntStages[stage]++;
        }

        int remainingPlayer = stages.length;
        ArrayList<Stage> stageList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            double failure = (double) cntStages[i]/remainingPlayer;
            remainingPlayer -= cntStages[i];
            Stage s = new Stage(i, failure);
            stageList.add(s);
            System.out.println(failure);
        }

//        이렇게 바로 직접 구현도 가능.
//        Collections.sort(stageList, new Comparator<Stage>() {
//            @Override
//            public int compare(Stage o1, Stage o2) {
//                if (o1.failure < o2.failure) {
//                    return 1;
//                } else if (o1.failure > o2.failure) {
//                    return -1;
//                } else return 0;
//            }
//        });

        int[] answer = new int[N];

        for (int i=0; i<N; i++) {
            answer[i] = stageList.get(i).phase;
        }

        return answer;
    }

    public static class Stage implements Comparable<Stage> {

        public int phase;
        public double failure;

        public Stage(int phase, double failure) {
            this.phase = phase;
            this.failure = failure;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure) {return -1;}
            else if (failure > o.failure) {return 1;}
            // NaN은 비교판단에서 항상 false 기 때문에 항상 else 문에서 처리 됨. 따라서 else문의 return값이
            // 무엇인지가 중요. 0이면 그대로 , 음수이면 작기때문에 리스트 맨앞에, 양수면 리스트 맨 뒤에
            else return 0;

        }

    }
}
