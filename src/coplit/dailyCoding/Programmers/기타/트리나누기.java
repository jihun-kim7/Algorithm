package coplit.dailyCoding.Programmers.기타.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 트리나누기 {
    /**
     1. 그래프마다 간선저장
     2. 노드에서 이어진 노드의 개수가 n//3 이면 체크(정답 배열에 저장)
     */
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        System.out.println(solution());

    }

    public static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
//        ArrayList<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] temp = new int[]{a,i};
            int[] temp2 = new int[]{b,i};
            list.get(a).add(temp2);
            list.get(b).add(temp);
        }

        dfs(list,map,0,0,n/3,answer);
        Collections.sort(answer);

        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public static int dfs(ArrayList<ArrayList<int[]>> list, Map<Integer, Integer> map, int pre, int now, int want, ArrayList<Integer> answer) {

        for (int i=0; i<list.get(now).size(); i++) {
            int[] arr = list.get(now).get(i);
            int next = arr[0];
            if (next == pre) continue;
            int edge = arr[1];
            int result = dfs(list,map,now,next,want,answer);
            if (result == want) {
                answer.add(edge);
                System.out.println(edge);
                continue;
            }
            map.put(now,map.getOrDefault(now,0)+result);
        }


        return map.getOrDefault(now,0)+1;
    }

}
