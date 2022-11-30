package coplit.dailyCoding.Programmers.기타.Lv1;

public class 최소직사각형 {


    // 처음에 입력으로 주어지는 배열만 봤을 땐 헷갈렸는데 생각해보니 지갑을 만드려면
    // 명함 중 가장 큰 길이가 고정적으로 필요하다. 지값의 가로길이를 최대값으로 설정하면
    // 세로 길이는 각 명함의 최소값들중 최대값이다.

    public int solution(int[][] sizes) {
        int length = 0, height = 0;

        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }

        return length * height;


        // 첫 풀이 . 코드는 더 길지만 2배가량 더 빠름
//        int maxVal = -1;
//        int minVal = -1;
//        int big;
//        int small;
//
//        for (int[] size : sizes) {
//            if (size[0] > size[1]) {
//                big = size[0];
//                small = size[1];
//            } else {
//                big = size[1];
//                small = size[0];
//            }
//
//            if (big > maxVal) {
//                maxVal = big;
//            }
//            if (small > minVal) {
//                minVal = small;
//            }
//        }
//
//        return maxVal * minVal;
    }
}
