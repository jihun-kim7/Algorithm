package coplit.dailyCoding.Programmers.l;

import java.util.Arrays;
import java.util.HashMap;

// LCS (최장 공통 부분 문자열)
public class 문제3lcs {
    public static void main(String[] args) {
        문제3lcs m = new 문제3lcs();
//        System.out.println(m.solution("vxrvip", "xrviprvipvxrv"));
        System.out.println(m.solution("abc", "bcab"));
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

        int answer = 1;
        int expect = 1;
        for (int i=1; i<track.length()+1; i++) {
            boolean findExpect = false;
            for (int j=1; j<reference.length()+1; j++) {
                if (arr[j][i] == expect){
                    findExpect = true;
                    break;
                }
            }
            if (findExpect) {
                answer = expect;
                expect++;
            } else {
                expect = 1;
            }
        }

        return answer;
    }

}
