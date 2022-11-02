package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }


    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name,map.get(name)-1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }

        return null;
    }
}
