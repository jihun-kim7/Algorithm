package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임 {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
    public static int solution(String dartResult) {
        Map<String,Integer> bonus = new HashMap<>() {{
            put("S",1);
            put("D",2);
            put("T",3);
        }};

        Map<String, Integer> option = new HashMap<>() {{
            put("*",2);
            put("#",-1);
            put("",1);
        }};

        Pattern p = Pattern.compile("(\\d+)([SDT])([*#]?)");
        Matcher m = p.matcher(dartResult);


        int[] answer = new int[3];

        for (int i = 1; i <= 3; i++) {
            m.find();
            if (i >= 2 && m.group(3).equals("*")) {
                answer[i-2] *= 2;
            }
            // map 없이 풀때
//            int bonus = 1;
//            if (m.group(2).equals("D")) bonus = 2;
//            else if(m.group(2).equals("T")) bonus = 3;
//
//            int option = 1;
//            if (m.group(3).equals("*")) option = 2;
//            else if(m.group(3).equals("#")) option = -1;
//
//            answer[i - 1] = (int) (Math.pow(Integer.parseInt(m.group(1)),bonus) * option) ;
            answer[i - 1] = (int) (Math.pow(Integer.parseInt(m.group(1)),bonus.get(m.group(2))) * option.get(m.group(3)));
        }

        return Arrays.stream(answer).sum();
    }
}
