package coplit.dailyCoding.solo;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangularArea {
    // naive solution: O(N^2)
    // public static int largestRectangularArea(int[] histogram) {
    //   int largest = 0;
    //   // 모든 연속된 부분 히스토그램을 고려한다.
    //   // 밑변의 길이를 부분 히스토그램의 길이로 고정하면, 높이는 가장 낮은 막대의 높이가 된다.
    //   for (int left = 0; left < histogram.length; left++) {
    //     // 길이가 1인 막대로 만들 수 있는 직사각형의 넓이는 막대의 높이와 같다.
    //     int min = histogram[left];
    //     for (int right = left; right < histogram.length; right++) {
    //       // left부터 right까지의 히스토그램의 막대 중 가장 낮은 막대의 높이를 구한다.
    //       if (histogram[right] < min) min = histogram[right];
    //       // 해당 구간(left ~ right)의 막대를 전부 포함해서 만들 수 있는 직사각형의 넓이를 구한다.
    //       int area = min * (right - left + 1);
    //       // 매번 구한 면적을 기존의 면적과 비교해 갱신한다.
    //       if (area > largest) largest = area;
    //     }
    //   }
    //   return largest;
    // }


    // naive solution: O(N)
    // PLE[i] = 인덱스 i 의 높이보다 낮은 왼쪽에서 첫번째 인덱스
    // NLE[i] = 인덱스 i 의 높이보다 낮은 오른쪽에서 첫번째 인덱스
    // PLE,NLE를 통해 인덱스 i의 밑변의 길이를 구한다. i의 밑변 * i의 높이 = i의 최대넓이 이다.
    // 인덱스 i의 왼쪽 변, 오른쪽 변이 존재하려면 인덱스 i의 높이와 같거나 더 커야 하므로, PLE[i], NLE[i]를 이용해
    // 좌변의 길이, 우변의 길이를 구하는 것이다.
    // 예를 들어 지금 i가 3인데 PLE[i] = 1 이면, 3 - PLE[i] - 1 해서 인덱스 i의 좌변의 길이는 1이고,
    // NLE[i] = 5이면 5 - i - 1 해서 인덱스 i의 우변의 길이는 1이다.
    // 인덱스 i까지 합쳐서 총 밑변의 길이는 3이고 높이는 4이므로 3*4 = 12 이런 식으로 각 i번 인덱스의 최대값을 구한다.
    public int largestRectangularArea(int[] histogram) {
        int maxArea = 0;
        int[] tempPLE = new int[histogram.length];
        int[] tempNLE = new int[histogram.length];
        Arrays.fill(tempPLE, -1);
        Arrays.fill(tempNLE, -1);

        int[] PLE = findPLE(tempPLE, histogram);
        int[] NLE = findNLE(tempNLE, histogram);
        for(int i = 0; i < histogram.length; i++) {
            int barsOnLeft = PLE[i] == -1 ? i : i - PLE[i] - 1; // i번 인덱스에서 왼쪽방향의 변의 길이
            int barsOnRight = NLE[i] == -1 ? histogram.length - 1 - i : NLE[i] - i - 1; // i번 인덱스에서 오른쪽방향의 변의 길이
            int width = barsOnLeft + barsOnRight + 1; // i번 인덱스 자신을 포함하므로 + 1
            maxArea = Math.max(maxArea, width * histogram[i]);
        }
        return maxArea;
    }
    public int[] findPLE(int[] PLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < histogram.length; i++) {
            // i번째 인덱스보다 높이가 크거나 같으면 stack에서 제외시킨다.(높이가 낮은걸 찾아서 PLE[i]에 넣기 위함)
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if(stack.size() > 0) {
                PLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return PLE;
    }

    public int[] findNLE(int[] NLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for(int i = histogram.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if(stack.size() > 0) {
                NLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return NLE;
    }
}
