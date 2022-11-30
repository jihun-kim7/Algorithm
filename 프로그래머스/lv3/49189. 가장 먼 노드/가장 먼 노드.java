import java.util.*;

class Solution {
    // 인접리스트 그래프 만들고 bfs 타기
    // int[] node 만들어서 최단경로 저장하고
    // 그중에서 가장 큰 값의 node 개수 센게 정답
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int cnt = 0;
        int[] path = new int[n+1];
        path[1] = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i=0; i<size; i++) {
                int node = q.poll();
                ArrayList<Integer> list = graph.get(node);
                for (int x : list) {
                    if(path[x]==0) {
                        q.offer(x);
                        path[x] = cnt;
                    }
                }
            }
        }


        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (path[i] == cnt-1) {
                answer++;
            }
        }


        return answer;
    }
}