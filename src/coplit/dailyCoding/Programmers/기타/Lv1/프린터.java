package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        Queue<Integer> printer = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            printer.add(priorities[i]);
        }

        int turn = 0;

        while (!printer.isEmpty()) {
            int job = printer.poll();
            if (printer.stream().anyMatch(otherJob -> job < otherJob)) {
                printer.add(job);
            } else {
                turn++;
                if (location == 0) {
                    break;
                }
            }
            location--;
            if (location < 0)
                location = printer.size()-1;
        }

        return turn;
    }

}
