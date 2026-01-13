package coplit.dailyCoding.solo;

import java.util.ArrayList;
import java.util.Arrays;

public class sudoku {
    static int[][] result;
    static boolean[][] rowCheck, colCheck, squCheck;
    static ArrayList<int[]> blank;

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 3, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };
        int[][] output = sudoku(board);
        System.out.println(Arrays.deepToString(output));
    }

    public static int[][] sudoku(int[][] board) {
//        result = new int[9][9];
        rowCheck = new boolean[9][10];
        colCheck = new boolean[9][10];
        squCheck = new boolean[9][10];
        blank = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0) {
                    blank.add(new int[]{r, c});
                } else {
                    rowCheck[r][board[r][c]] = true;
                    colCheck[c][board[r][c]] = true;
                    squCheck[(r / 3 * 3) + (c / 3)][board[r][c]] = true;
                }
            }
        }

        dfs(board, 0);
        return board;
    }

    public static boolean dfs(int[][] board, int count) {
        if (count == blank.size()) return true;

        int[] data = blank.get(count);
        int r = data[0];
        int c = data[1];

        for (int i=1; i<=9; i++) {
            if (rowCheck[r][i] || colCheck[c][i] || squCheck[(r / 3 * 3) + (c / 3)][i]) continue;
            rowCheck[r][i] = true;
            colCheck[c][i] = true;
            squCheck[(r / 3 * 3) + (c / 3)][i] = true;
            board[r][c] = i;

            if (dfs(board, count + 1)) return true;

            rowCheck[r][i] = false;
            colCheck[c][i] = false;
            squCheck[(r / 3 * 3) + (c / 3)][i] = false;
            board[r][c] = 0;
        }
        return false;
    }
}
