import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int n = maps.length;
        int m = maps[0].length;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[0] == n-1 && poll[1] == m-1) {
                return poll[2];
            }
            for (int[] d : dir) {
                int nr = poll[0] + d[0];
                int nc = poll[1] + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && maps[nr][nc] == 1) {
                    queue.offer(new int[]{nr, nc, poll[2]+1});
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }
}