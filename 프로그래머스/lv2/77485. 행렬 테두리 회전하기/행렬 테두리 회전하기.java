import java.io.*;
import java.util.*;

class Solution {
    static int[][] table;
    static int minVal;

    public int[] solution(int rows, int columns, int[][] queries) {
        table = new int[rows + 1][columns + 1];
        int count = 0;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                ++count;
                table[i][j] = count;
            }
        }
        int[] answer = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            minVal = 10000;
            rotate(q[0], q[1], q[2], q[3]);
            answer[i++] = minVal;
        }


        return answer;
    }

    static void rotate(int sr, int sc, int er, int ec) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(table[sr][sc]);
        for (int j = sc + 1; j < ec; j++) {//맨윗줄
            q.offer(table[sr][j]);
            table[sr][j] = q.remove();
            minVal = Math.min(minVal, table[sr][j]);
        }
        for (int i = sr; i < er; i++) {//우
            q.offer(table[i][ec]);
            table[i][ec] = q.remove();
            minVal = Math.min(minVal, table[i][ec]);
        }
        for (int j = ec; j > sc; j--) {//하
            q.offer(table[er][j]);
            table[er][j] = q.remove();
            minVal = Math.min(minVal, table[er][j]);
        }
        for (int i = er; i >= sr; i--) {//좌
            q.offer(table[i][sc]);
            table[i][sc] = q.remove();
            minVal = Math.min(minVal, table[i][sc]);
        }
    }
}