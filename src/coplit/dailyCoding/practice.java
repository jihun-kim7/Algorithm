package coplit.dailyCoding;

import java.util.ArrayList;

public class practice {
    int[][] square;

    public int[] solution(int rows, int columns, int[][] queries) {

        square = new int[rows][columns];

        int preNum = 0;
        for(int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                square[r][c] = ++preNum;
            }
        }

        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            answer[i] = rotate(square, queries[i]);
        }

        return answer;
    }

    public int rotate(int[][] square, int[] query) {
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;

        int memory = square[x1][y2];
        int minNum = memory;


        // 한칸씩 계속 떙긴다
        for(int y=y2; y>y1; y--) {
            minNum = Math.min(minNum, square[x1][y]);
            square[x1][y] = square[x1][y-1];
        }

        for(int x=x1; x<x2; x++) {
            minNum = Math.min(minNum, square[x][y1]);
            square[x][y1] = square[x+1][y1];
        }

        for(int y=y1; y<y2; y++) {
            minNum = Math.min(minNum, square[x2][y]);
            square[x2][y] = square[x2][y+1];
        }

        for(int x=x2; x>x1+1; x--) {
            minNum = Math.min(minNum, square[x][y2]);
            square[x][y2] = square[x-1][y2];
        }

        minNum = Math.min(minNum, square[x1+1][y2]);
        square[x1+1][y2] = memory;

        return minNum;
    }
}
