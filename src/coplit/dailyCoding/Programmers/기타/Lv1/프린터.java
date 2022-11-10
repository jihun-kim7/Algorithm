package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        List<Integer> printer = Arrays.stream(priorities).boxed().collect(Collectors.toList());

        int turn = 0;

        while (!printer.isEmpty()) {
            Integer job = printer.remove(0);
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
                location = printer.size() - 1;
        }

        return turn;
    }

}
