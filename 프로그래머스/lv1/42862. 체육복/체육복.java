import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n + 2];

        for (int l : lost) {
            people[l]--;
        }

        for (int r : reserve) {
            people[r]++;
        }

        int answer = n;
        for (int i=1; i<n+1; i++) {
            if (people[i] != -1) {
                continue;
            }
            if (people[i - 1] == 1) {
                people[i - 1]--;
            } else if (people[i + 1] == 1) {
                people[i + 1]++;
            } else answer--;
        }
        
        return answer;
    }
}