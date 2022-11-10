package coplit.dailyCoding.Programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        //1.info 돌면서 모든 map 만들기
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for (String str : info) {
            String[] data = str.split(" ");
            String[] language = {data[0], "-"};
            String[] job = {data[1], "-"};
            String[] carrer = {data[2], "-"};
            String[] food = {data[3], "-"};
            int score = Integer.parseInt(data[4]);

            for (String lan : language) {
                for (String j : job) {
                    for (String c : carrer) {
                        for (String f : food) {
                            String s = lan + j + c + f;
                            ArrayList<Integer> li = hashMap.getOrDefault(s, new ArrayList<Integer>());
                            li.add(score);
                            hashMap.put(s, li);
                        }
                    }
                }
            }
        }

        for (ArrayList<Integer> list : hashMap.values())
            Collections.sort(list);

        //2.이분탐색으로 정답구하기
        int[] answer = new int[query.length];
        int i = 0;
        for (String q : query) {
            String[] str = q.split(" and ");
            String[] temp = str[3].split(" ");
            str[3] = temp[0];
            int score = Integer.parseInt(temp[1]);
            ArrayList<Integer> list = hashMap.getOrDefault(String.join("", str), new ArrayList<Integer>());
            int left = 0;
            int right = list.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < score)
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            answer[i] = list.size() - left;
            i++;
        }

        return answer;
    }
}
