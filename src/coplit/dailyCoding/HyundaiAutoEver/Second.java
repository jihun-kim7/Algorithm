package coplit.dailyCoding.HyundaiAutoEver;

import java.io.*;
import java.util.*;

public class Second {

    // 1. 화살의 굵기별로 과녁 특정 지점을 맞췄을때 얻는 점수를 구한다.
    // 2. 완전탐색한다.

    static int[][] board;
    static int N,M,K;
    static Map<Integer, List<Integer>> scoreMap = new HashMap<>();
    static int answer = Integer.MAX_VALUE;
    static int targetScore = 15;

    // 북동남서
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = i+j+1;
            }
            System.out.println(Arrays.toString(board[i]));
        }

        for (int i=1; i<=K; i++) {
            scoreMap.put(i,new ArrayList<>());
            for (int r=0; r<N; r++) {
                for (int c=0; c<M; c++) {
                    int score = getScore(r,c,i);
                    scoreMap.get(i).add(score);
                }
            }
        }

        System.out.println(scoreMap);

        findAnswer(0,0,new boolean[K+1], new ArrayList<>());

        System.out.println(answer);
    }

    // get scores;
//    public static int getScore(int r, int c, int k) {
//
//        boolean[][] visited = new boolean[N][M];
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{r,c,0});
//        visited[r][c] = true;
//        int score = 0;
//
//        while(!q.isEmpty()) {
//            int[] current = q.poll();
//            r = current[0]; c = current[1]; int dist = current[2];
//
//            if (dist < k) {
//                score += board[r][c];
//                for (int i=0; i<4; i++) {
//                    int nr = r+dr[i]; int nc = c+dc[i];
//                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
//                        q.add(new int[]{nr,nc,dist+1});
//                        visited[nr][nc] = true;
//                    }
//                }
//            }
//        }
//
//        return score;
//    }

    public static int getScore(int r, int c, int k) {
        int score = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int dist = Math.abs(r-i) + Math.abs(c-j);
                if (dist < k) {
                    score += board[i][j];
                }
            }
        }

        return score;
    }


    // 완전탐색
    public static void findAnswer(int score,int power, boolean[] visited, List<Integer> scoreList) {

        if (score > targetScore) {
            return;
        }

        if (score == targetScore) {
            answer = Math.min(answer,power);
            return;
        }

        for (int i=1; i<=K; i++) {
            if (!visited[i]) {
                List<Integer> list = scoreMap.get(i);
                for (int j=0; j<N*M; j++) {
                    visited[i] = true;
                    int s = list.get(j);
                    scoreList.add(s);
                    findAnswer(score+s, power+i,visited,scoreList);
                    scoreList.remove(scoreList.size()-1);
                    visited[i] = false;
                }
            }
        }
    }

}
