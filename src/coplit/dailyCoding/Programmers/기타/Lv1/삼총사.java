package coplit.dailyCoding.Programmers.기타.Lv1;

public class 삼총사 {

    // 그냥 3중 for문 써도 상관 없음 . nC3 조합만들기 문제
//    public static void main(String[] args) {
//        System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
//    }

    public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i+1; j < number.length - 1; j++) {
                for (int k = j+1; k < number.length; k++) {
                    if ((number[i] + number[j] + number[k]) == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

//    public static int solution(int[] number) {
//        return choice(0,0,number,0,0);
//    }
//
//    public static int choice(int cnt, int sumNum, int[] number, int start, int answer) {
//        if (cnt == 3) {
//            if (sumNum == 0) {return answer+1;}
//            return answer;
//        }
//
//        for (int i = start; i < number.length; i++) {
//            answer = choice(cnt+1,sumNum+number[i],number,i+1, answer);
//        }
//
//        return answer;
//    }
}
