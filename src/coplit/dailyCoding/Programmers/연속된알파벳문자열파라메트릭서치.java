package coplit.dailyCoding.Programmers;

public class 연속된알파벳문자열파라메트릭서치 {
    public static void main(String[] args) {
        System.out.println(solution("aaabbbc",3));
    }

    public static int solution(String str, int n) {
        int left = 1;
        int right = str.length()-n;
        int answer = 0;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (isPossible(str,n,0, 0, mid)) {
               right = mid - 1;
               answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static boolean isPossible(String str,int n, int idx, int splitCnt, int mid) {

        if (splitCnt > n) {
            return false;
        }

        int cnt = 1;
        char preAlphabet = ' ';

        for (int i = idx; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == preAlphabet) {
                cnt++;
            } else {
                cnt = 1;
            }
            preAlphabet = ch;

            if (cnt > mid) {
                return isPossible(str,n,i,splitCnt+1,mid);
            }
        }

        return true;
    }
}
