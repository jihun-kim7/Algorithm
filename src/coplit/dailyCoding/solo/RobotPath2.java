package coplit.dailyCoding.solo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs를 이용한 풀이
 * 1. 일단 4방향으로 갈수 있는 데 까지 가고,방문하지 않았으면 que에 추가한다. ( 동작의 수 같이 저장 )
 * 2. 계속 푼다
 */


public class RobotPath2 {
    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
        };
        int[] src = new int[]{4, 2};
        int sDir = 1;
        int[] dst = new int[]{2, 2};
        int dDir = 3;
        int output = robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 7
    }

    public static int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        // TODO:
        int M = room.length;
        int N = room[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int[][] visited = new int[M][N];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] arr : visited) {
            Arrays.fill(arr,0);
        }
        visited[src[0]][src[1]] = 1;
        queue.offer(new int[]{src[0],src[1],sDir-1,0});
        int nMove;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int r = data[0];
            int c = data[1];
            int nDir = data[2];
            int move = data[3];

            if (r == dst[0] && c == dst[1]) {
                nMove = Math.abs(dDir-1-nDir);
                if (nMove == 3) nMove = 1;
                return move+nMove;
            }

            for (int i=0; i<4; i++) {
                int dir = (nDir+i)%4;
                if (i == 3) nMove = 1;
                else nMove = i;
                int dr = dirs[dir][0];
                int dc = dirs[dir][1];
                int nr = r+dr;
                int nc = c+dc;
                nMove += 1;
                while (0<=nr && nr<M && 0<=nc && nc<N && room[nr][nc] == 0 && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    queue.offer(new int[]{nr,nc,dir,move+nMove});
                    nr += dr;
                    nc += dc;
                }
            }
        }
        return -1;
    }
}
