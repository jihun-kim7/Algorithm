package coplit.dailyCoding;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GossipProtocol {

    public static void main(String[] args) {
        String[] village = new String[]{
                "0101", // 첫 번째 줄
                "0111",
                "0110",
                "0100"};
        int row = 1;
        int col = 2;
        int output = gossipProtocol(village, row, col);
        System.out.println(output); // --> 3
    }

    public static int gossipProtocol(String[] village, int row, int col) {
        // TODO :
        int[][] matrix = createMatrix(village);

        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int r = data[0];
            int c = data[1];

            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                int nr = r+dir[0];
                int nc = c+dir[1];

                if (nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[0].length || matrix[nr][nc] != 1) {
                    continue;
                }

                matrix[nr][nc] = matrix[r][c] + 1;
                queue.offer(new int[]{nr,nc});
            }

        }

        System.out.println(Arrays.deepToString(matrix));

        int maxVal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                }
            }
        }


        return maxVal-1;
    }

    public static int[][] createMatrix(String[] village) {
        int[][] matrix = new int[village.length][];
        for(int i = 0; i < village.length; i++) {
            String str = village[i];
            int[] row = new int[str.length()];
            for(int j = 0; j < str.length(); j++) {
                row[j] = Character.getNumericValue(str.charAt(j));
            }
            matrix[i] = row;
        }
        return matrix;
    }

}
