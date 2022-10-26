package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(set.size(), nums.length / 2);
    }
}
