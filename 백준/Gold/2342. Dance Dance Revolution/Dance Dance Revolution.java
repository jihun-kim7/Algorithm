import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 1.입력 지시사항대로 가장 적은 힘으로 이동한다.

    // 그리디로 풀면 안됐다.. 같은 발판을 밟아야 하는 경우에도, 계속 왔다갔다하면서 밟게 되는 경우가 있음.

    static int[] move;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        move = new int[line.length-1];
        for(int i=0; i<line.length-1; i++) {
            move[i] = Integer.parseInt(line[i]);
        }

        dp = new int[5][5][line.length];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(solve(0,0,0));
    }

    static int solve(int left, int right, int cnt) {

        if(cnt == move.length) return 0;

        if(dp[left][right][cnt] != -1 ) return dp[left][right][cnt];

        dp[left][right][cnt] = Math.min(solve(move[cnt],right, cnt+1) + energy(left, move[cnt]),
                solve(left, move[cnt], cnt+1) + energy(right,move[cnt]));
        return dp[left][right][cnt];
    }

    static int energy(int pos, int des) {
        int num = Math.abs(pos-des);
        if(pos ==0) return 2;
        else if(num == 0) return 1;
        else if(num == 1|| num ==3) return 3;
        else return 4;
    }
}
