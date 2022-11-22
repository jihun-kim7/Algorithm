import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> square = new ArrayList<>();

    public int[] solution(int rows, int columns, int[][] queries) {

        int preNum = 0;
        for(int r=0; r<rows; r++) {
            square.add(new ArrayList<>());
            for (int c=0; c<columns; c++) {
                square.get(r).add(++preNum);
            }
        }

        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            answer[i] = rotate(square, queries[i]);
        }

        return answer;
    }

    public int rotate(ArrayList<ArrayList<Integer>> square, int[] query) {
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;

        int memory = square.get(x1).get(y2);
        int minNum = memory;
        
        
        // 한칸씩 계속 떙긴다
        for(int y=y2; y>y1; y--) {
            minNum = Math.min(minNum, square.get(x1).get(y));
            square.get(x1).set(y,square.get(x1).get(y-1));
        }

        for(int x=x1; x<x2; x++) {
            minNum = Math.min(minNum, square.get(x).get(y1));
            square.get(x).set(y1,square.get(x+1).get(y1));
        }

        for(int y=y1; y<y2; y++) {
            minNum = Math.min(minNum, square.get(x2).get(y));
            square.get(x2).set(y,square.get(x2).get(y+1));
        }

        for(int x=x2; x>x1+1; x--) {
            minNum = Math.min(minNum, square.get(x).get(y2));
            square.get(x).set(y2,square.get(x-1).get(y2));
        }

        minNum = Math.min(minNum,square.get(x1+1).get(y2));
        square.get(x1+1).set(y2,memory);

        return minNum;
    }
}