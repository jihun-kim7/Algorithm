import java.util.*;
 
class Solution {
    
	static int N;
	static int[][][] cnt;
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1}; //상하좌우
	static Queue<Node> q = new LinkedList<>();
    public static int solution(int[][] board) {
    	N = board.length;
    	cnt = new int[N][N][4]; // 3차원 배열 좌표 방향으로 이동정보 저장
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					cnt[i][j][k] = Integer.MAX_VALUE; // 일단 이동해야하는 곳들을 최대값으로 갱신한다.
				}
			} 
		}
    	if(board[0][1] == 0) { // 0,0에서 오른쪽 갈수있으면 직진하고 큐에담음
    		cnt[0][1][3] = 100; 
    		q.add(new Node(0,1,3));
    	}
    	if(board[1][0] == 0) { // 0,0에서 아래 갈수있으면 직진하고 큐에담음
    		cnt[1][0][1] = 100;
    		q.add(new Node(1,0,1));
    	}
    	bfs(board); //bfs 돌림
    	int answer = cnt[N-1][N-1][0]; // 방향별 최종값중 최소값 찾기
    	for (int k = 1; k < 4; k++) {
			answer = Math.min(answer, cnt[N-1][N-1][k]);
		}
    	return answer;
    }
	
	private static void bfs(int[][] board) {
		while(!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 1) // 배열 범위 벗어나거나 벽인경우
					continue;
				if (i == n.d) { // 직진
					if(cnt[ny][nx][i] > cnt[n.y][n.x][n.d]+100) { // 가려는 곳이 클경우 갱신 필요
						cnt[ny][nx][i] = cnt[n.y][n.x][n.d]+100;
						q.offer(new Node(ny,nx,i));
					}
				} else { // 곡선
					if(cnt[ny][nx][i] > cnt[n.y][n.x][n.d]+600) { // 가려는 곳이 클경우 갱신 필요
						cnt[ny][nx][i] = cnt[n.y][n.x][n.d]+600;
						q.offer(new Node(ny,nx,i));
					}
				}
			}
		}
	}
 
	static class Node{
		int y, x, d;
		Node(int y, int x,  int d){
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}