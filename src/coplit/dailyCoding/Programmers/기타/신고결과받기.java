package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        //1.hashset 만들어서 신고는 1회만 하도록 중복 제거
        HashSet<String> reportSet = new HashSet<String>();
        Collections.addAll(reportSet, report);
        //2.key=신고당한사람, value=신고한사람 리스트로 hashmap 생성
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();

        for(String rep : reportSet) {
            String[] arr = rep.split(" ");
            String reporter = arr[0];
            String reportee = arr[1];

            ArrayList<String> reportList = reportMap.getOrDefault(reportee,new ArrayList<String>());
            reportList.add(reporter);
            reportMap.put(reportee,reportList);
        }
        //3.value가 k이상일때만 신고한사람한테 +=1 하는 hashmap 생성
        HashMap<String,Integer> successReportMap = new HashMap<>();

        for(ArrayList<String> rep : reportMap.values()) {
            if (rep.size() >= k) {
                for(String person : rep) {
                    successReportMap.put(person, successReportMap.getOrDefault(person,0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        for (int i=0; i<id_list.length; i++) {
            answer[i] = successReportMap.getOrDefault(id_list[i],0);
        }

        return answer;
    }
}
