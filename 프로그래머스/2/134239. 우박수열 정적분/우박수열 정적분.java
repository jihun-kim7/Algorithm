import java.util.*;

class Solution {
    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Double> list = new ArrayList<>();

        int n = 0;

        while (k != 1) {
            int rem = k;
            if (k % 2 == 0) k /= 2;
            else k = 3 * k + 1;

            double width = (double) (rem + k) / 2;

            list.add(width);
            n++;

        }


        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            int x = n + b;

            if (x < a) {
                answer[i] = -1.0;
                continue;
            } else if (a == x) {
                answer[i] = 0.0;
                continue;
            }

            double sum = 0;

            for (int j=a; j<x; j++) {
                sum += list.get(j);
            }

            answer[i] = sum;
        }

        return answer;
    }
}