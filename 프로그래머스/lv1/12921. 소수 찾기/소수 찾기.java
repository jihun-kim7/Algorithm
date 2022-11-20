class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!visited[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    visited[j] = true;
                }
            }
        }

        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {answer++;}
        }

        return answer;
    }
}