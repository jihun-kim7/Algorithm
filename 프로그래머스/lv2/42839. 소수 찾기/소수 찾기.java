import java.util.*;

class Solution {
    // 1. 모든 순열 만든다.
    // 2. 소수인지 검사한다
    
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        makePerm(numbers,"");
        return set.size();
    }
    
    public void makePerm(String numbers, String perm) {
        int num;
        if(!perm.equals("")) {
            num = Integer.parseInt(perm);
            if (!set.contains(num) && check(num)) {
            set.add(num);
            }
        }
    
        
        for (int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                makePerm(numbers,perm+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public boolean check(int num) {
        if (num == 0 || num == 1) return false;
        if (num == 2) return true;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num%i==0) return false;
        }
        
        return true;
    }
}