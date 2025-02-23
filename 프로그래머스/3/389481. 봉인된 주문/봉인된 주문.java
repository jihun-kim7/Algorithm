import java.util.*;
  
class Solution {
    public String solution(long n, String[] bans) {
        // 1. 미리 26의 거듭제곱 값을 계산 (길이 1~11에 대해)
        long[] pow26 = new long[12];
        pow26[0] = 1;
        for (int i = 1; i < 12; i++) {
            pow26[i] = pow26[i - 1] * 26;
        }
        
        // 2. 길이별로 삭제된 주문의 인덱스(0부터 시작하는 base-26 값)를 저장할 리스트를 준비
        @SuppressWarnings("unchecked")
        List<Long>[] bannedLists = new ArrayList[12];
        for (int i = 1; i < 12; i++) {
            bannedLists[i] = new ArrayList<>();
        }
        for (String s : bans) {
            int len = s.length();
            long idx = 0;
            // s를 base-26 숫자로 변환 ('a' -> 0, 'b' -> 1, …)
            for (int i = 0; i < len; i++) {
                idx = idx * 26 + (s.charAt(i) - 'a');
            }
            bannedLists[len].add(idx);
        }
        // 각 길이별 banned 리스트를 정렬
        for (int i = 1; i < 12; i++) {
            Collections.sort(bannedLists[i]);
        }
        
        // 3. 각 길이별로 유효한 주문의 개수를 누적하면서 n번째 주문이 어느 길이에 속하는지 찾음
        long cumulative = 0;
        int targetLen = 0;
        for (int len = 1; len < 12; len++) {
            long totalCount = pow26[len]; // 길이가 len인 모든 주문의 수
            long bannedCount = bannedLists[len].size(); // 삭제된 주문의 수
            long validCount = totalCount - bannedCount; // 실제 남은 주문의 수
            if (cumulative + validCount >= n) {
                targetLen = len;
                break;
            }
            cumulative += validCount;
        }
        
        // targetLen 길이 그룹 내에서 몇 번째 유효 주문인지 (0-indexed)
        long indexInGroup = n - cumulative - 1;
        
        // 4. targetLen 길이의 모든 주문은 0부터 (26^targetLen - 1)의 인덱스로 매겨짐.
        //    banned 리스트에 있는 인덱스들을 제외하고, indexInGroup번째 유효한 주문의 실제 인덱스를 구함.
        long answerIndex = 0;
        List<Long> bannedList = bannedLists[targetLen];
        long prev = -1;
        boolean found = false;
        for (long b : bannedList) {
            long gap = b - (prev + 1);  // 이전 삭제된 주문 다음부터 현재 삭제 주문 전까지의 유효 주문 수
            if (indexInGroup < gap) {
                answerIndex = prev + 1 + indexInGroup;
                found = true;
                break;
            }
            indexInGroup -= gap;
            prev = b;
        }
        if (!found) {  // bannedList의 마지막 이후에도 남은 경우
            answerIndex = prev + 1 + indexInGroup;
        }
        
        // 5. answerIndex를 targetLen 자리의 주문 문자열로 변환 (base-26 표기)
        char[] res = new char[targetLen];
        for (int i = targetLen - 1; i >= 0; i--) {
            res[i] = (char)('a' + (int)(answerIndex % 26));
            answerIndex /= 26;
        }
        return new String(res);
    }
}
