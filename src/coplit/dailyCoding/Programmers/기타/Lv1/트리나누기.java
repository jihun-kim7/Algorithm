package coplit.dailyCoding.Programmers.기타.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리나누기 {
    /**
     1. 그래프마다 간선저장
     2. 노드에서 이어진 노드의 개수가 n//3 이면 체크(정답 배열에 저장)
     */

    public static void main(String[] args) {

    }

    public static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, Map<Integer, Integer> map, int pre, int now) {
        map.put(now, map.getOrDefault(now,0) + 1);

        for (int i=0; i<list.get(now).size(); i++) {
            if (pre == now) continue;
            dfs(list,map,now,i);
        }
    }

}
