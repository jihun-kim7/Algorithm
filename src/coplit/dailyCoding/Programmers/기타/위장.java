package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 위장 {

    public static void main(String[] args) {
        위장 c = new 위장();
        System.out.println(c.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] arr : clothes) {
            hashMap.put(arr[1], hashMap.getOrDefault(arr[1], 0)+1);
        }
        int sum = 1;
        for (int x : hashMap.values()) {
            sum *= (x+1);
        }

        return sum - 1;
    }


}
