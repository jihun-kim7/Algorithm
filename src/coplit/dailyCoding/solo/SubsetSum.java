package coplit.dailyCoding.solo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubsetSum {

    public static void main(String[] args) {
        int output = subsetSum(new int[]{20, 80, 99, 27, 35}, 100);
        System.out.println(output); // --> 100 (= 20 + 80)
    }

    public static int subsetSum(int[] set, int bound) {

        Set<Integer> cached = new HashSet<>();

        for (int member : set) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int cach : cached) {
                if ((cach + member) > bound) continue;
                temp.add(cach + member);
            }

            cached.addAll(temp);

            if (member <= bound) cached.add(member);
        }
        return cached.stream().mapToInt(n -> n).max().orElse(0);
    }
}
