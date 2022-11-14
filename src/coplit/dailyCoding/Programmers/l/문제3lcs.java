package coplit.dailyCoding.Programmers.l;

import java.util.Arrays;
import java.util.HashMap;

// LCS (최장 공통 부분 문자열)
public class 문제3lcs {

    int answer = 1;
    public static void main(String[] args) {
        문제3lcs m = new 문제3lcs();
//        System.out.println(m.solution("vxrvip", "xrviprvipvxrv"));
        System.out.println(m.solution("aaabbcc", "aabc"));
    }

    public int solution(String reference, String track) {

        int[][] arr = new int[reference.length()+1][track.length()+1];

        for (int i=0; i<reference.length(); i++) {
            for (int j=0; j<track.length(); j++) {
                if (reference.charAt(i) == track.charAt(j)) {
                    arr[i+1][j+1] = arr[i][j] + 1;
                }
            }
        }

        // 백트래킹
        findAnswer(arr, track.length(),Integer.MAX_VALUE);

        return answer;
    }

    public void findAnswer(int[][] arr, int col,int minVal) {
        if (col == 0) {
            System.out.println("answer : " + minVal);
            answer = minVal;
            return;
        }


        for (int i=arr.length-1; i>=0; i--) {
            System.out.println("row : " + i + " col : " + col + " arr[i][j] : " + arr[i][col]);
            if (arr[i][col] <= answer) continue;
            System.out.println("이걸로한다");
            findAnswer(arr, col-arr[i][col],Math.min(minVal,arr[i][col]));
        }
    }

}
