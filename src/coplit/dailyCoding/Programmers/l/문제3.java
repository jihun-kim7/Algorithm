package coplit.dailyCoding.Programmers.l;

import java.util.HashMap;

public class 문제3 {
    public static void main(String[] args) {
        문제3 m = new 문제3();
//        System.out.println(m.solution("vxrvip", "xrviprvipvxrv"));
//        System.out.println(m.solution("abczxcv", "bczabcbczxcv"));
//        System.out.println(m.solution("aaabbcc", "aabc"));
        System.out.println(m.solution("abaacac", "aaac"));
    }

    public int solution(String reference, String track) {


        HashMap<String, Boolean> subsHashMap = new HashMap<>();

        for (int i = 0; i < reference.length(); i++) {
            for (int j = i + 1; j < reference.length() + 1; j++) {
                subsHashMap.put(reference.substring(i, j), true);
            }
        }

        int left = 1;
        int right = reference.length();
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("left : " + left + " mid : " + mid + " right : " + right);
            if (isPossible(mid, subsHashMap, track, 0, new StringBuilder())) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public boolean isPossible(int mid, HashMap<String, Boolean> subsHashMap, String track, int idx, StringBuilder nowStr) {
        System.out.println(mid + " " + idx + " " + nowStr);

        for (int i = idx; i < track.length(); i++) {
            char ch = track.charAt(i);
            nowStr.append(ch);
            System.out.println(nowStr);
            if (!subsHashMap.containsKey(nowStr.toString())) {
                System.out.println(nowStr + "없음");
                return false;
            } else {
                if ((nowStr.toString()).length() >= mid) {
                    if (isPossible(mid, subsHashMap, track, i+1, nowStr)) {
                        return true;
                    } else {
                        nowStr = new StringBuilder();
                        System.out.println("nowStr 초기화");
                        if (mid > track.length()-1-i) {
                            System.out.println("그냥 바로 false");
                            return false;
                        }
                    }
                }
            }
        }

        return nowStr.length() >= mid;
    }
}