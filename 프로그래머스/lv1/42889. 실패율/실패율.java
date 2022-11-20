import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
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
        }

        Collections.sort(stageList, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if (o1.failure < o2.failure) {
                    return 1;
                } else if (o1.failure > o2.failure) {
                    return -1;
                } else return 0;
            }
        });

        int[] answer = new int[N];

        for (int i=0; i<N; i++) {
            answer[i] = stageList.get(i).phase;
        }

        return answer;
    }

    public class Stage implements Comparable<Stage> {

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
            else return 0;
        }

    }
}